package com.ford.xapi.manager

import com.ford.xapi.models.request.XApiDashboardRequest
import com.ford.xapi.models.response.XApiDashboardResponse
import com.ford.xapi.provider.XApiProvider
import org.graalvm.compiler.nodes.memory.MemoryCheckpoint
import sun.security.krb5.internal.KDCOptions.with

  
//import android.os.Build 
//import com.ford.xapi.OpenForTesting 
//import com.ford.xapi.database.XApiDataModel 
//import com.ford.xapi.models.request.XApiDashboardRequest 
//import com.ford.xapi.models.response.XApiDashboardResponse 
//import com.ford.xapi.provider.XApiLogoutEventProvider 
//import com.ford.xapi.provider.XApiDataModelAdapter 
//import com.ford.xapi.provider.XApiProvider 
//import com.ford.xapi.util.RefreshType 
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.atomic.AtomicReference 
import javax.inject.Inject 
import javax.inject.Singleton  


@Singleton
@OpenForTesting
class XApiDashboardManager @Inject constructor(
        private val xApiProvider: XApiProvider,
        private val dataModelAdapter: XApiDataModelAdapter,
        private val entityProcessor: XApiEntityProcessor,
        logoutProvider: XApiLogoutEventProvider
) {

    init { logoutProvider.doOnLogout { dataModelAdapter.deleteModel() } }

    /**
     * Returns Single<XApiResponse> that contains valid values for all XApi Dashboard Entites
     *
     * If the database is cleared. The XApiManager will request all XApi data
     * from the network and create a fresh cache database using that data replacing the old database
     *
     * @return Single<XApiResponse>
     */
    fun clearThenRefresh(): MemoryCheckpoint.Single<XApiDashboardResponse> = MemoryCheckpoint.Single
            .fromCallable { dataModelAdapter.deleteModel() }
            .flatMap { invalidateRefresh() }

    /**
     * Returns Single<XApiResponse> that contains valid values for all XApi Dashboard Entities
     *
     * If the network fails the database is NOT cleared. The XApiManager will request all XApi data
     * from the network and create a fresh cache database using that data replacing the old database
     *
     * @return Single<XApiResponse>
     */
    fun invalidateRefresh() = getData(XApiDashboardRequest(RefreshType.INVALIDATE.type))

    /**
     * Returns Single<XApiResponse> that will satisfy the requestOverride if present and it will contain
     * valid values for all XApiData Entities
     *
     * A network call is made when there is a requestOverride and or there is stale data else
     * valid cached data is returned. Network errors are propagated to all subscribers at the
     * time that they occur.
     *
     * @param requestOverride is an optional XApiRequest that will be sent to the network
     *
     * @return Single<XApiResponse>
     */
    fun getData(requestOverride: XApiDashboardRequest? = null): Single<XApiDashboardResponse> = run {
        with(entityProcessor) {
            requestOverride?.let { override ->
                forceRequest.update { compositeRequest ->
                    compositeRequest?.mergeRequest(override) ?: override
                }
            }
        }
        sharedUpdate
    }

    private val forceRequest = AtomicReference<XApiDashboardRequest?>(null)

    private var sharedUpdate = buildSharedUpdateObservable()

    private fun buildSharedUpdateObservable(): Single<XApiDashboardResponse> =
            dataModelAdapter.getModel()
                    .flatMap { getDataAndUpdateModel(it) }
                    .repeatUntil { requestIsEmpty() }
                    .takeLast(1)
                    .doOnError { sharedUpdate = buildSharedUpdateObservable() }
                    .share()
                    .singleOrError()

    private fun requestIsEmpty() = forceRequest.get() == null

    private fun getDataAndUpdateModel(model: XApiDataModel) = with(entityProcessor) {
        model.calculateRequest()
                .mergeRequest(takeCompositeRequest())
                .optimizeRequest(model)
                .takeUnless { requestIsInvalid() }
                ?.let { request ->
                    when (request.dashboardRefreshRequest) {
                        RefreshType.INVALIDATE.type -> updateInvalidateRefresh()
                        else -> updateFromNetwork(request, model)
                    }
                }
                ?: Single.just(model.accumulatedResponse)
    }

    private fun takeCompositeRequest() {
        forceRequest.getAndSet(null) ?: XApiDashboardRequest()
    }

    private fun requestIsInvalid() =
            it.isRequestEmpty() && it.dashboardRefreshRequest != RefreshType.INVALIDATE.type

    //if stale data or forced update
    private fun updateInvalidateRefresh() =
            updateFromNetwork(XApiDashboardRequest(RefreshType.ALL.type), XApiDataModel())

    private fun updateFromNetwork(request: XApiDashboardRequest, model: XApiDataModel) =
            xApiProvider.getXapiDashboardRefresh(request)
                    .map { response -> updateDataModelAndGetAccumulatedResponse(response, model) }

    private fun updateDataModelAndGetAccumulatedResponse(response: XApiDashboardResponse, model: XApiDataModel) =
            model.run {
                with(entityProcessor) {
                    accumulatedResponse = accumulatedResponse.mergeResponse(response)
                    updateCacheControlMap()
                    updateLastRefreshedMap(response)
                    updateLastModifiedMap(response)
                }
                dataModelAdapter.updateModel(model)
                accumulatedResponse
            }

    private fun <T> AtomicReference<T>.update(updater: (t: T) -> T) =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                this.getAndUpdate(updater)
            else {
                var currentValue: T
                do {
                    currentValue = this.get()
                } while (!this.compareAndSet(currentValue, updater(currentValue)))
                currentValue
            }
}