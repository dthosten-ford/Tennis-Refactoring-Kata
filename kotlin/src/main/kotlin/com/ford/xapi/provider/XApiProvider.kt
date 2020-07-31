package com.ford.xapi.provider

import `package com`.ford.xapi.services.XApiService
import com.ford.locale.ServiceLocaleProvider.ServiceLocaleProvider
import com.ford.xapi.models.request.XApiDashboardRequest
import com.google.inject.Inject
import java.util.*

class XApiProvider @Inject constructor(
        private val xApiService: XApiService,
        private val localeProvider: ServiceLocaleProvider,
        private val asdnAuthTokenProvider: ASDNAuthTokenProvider
) {

    fun getXapiDashboardRefresh(request: XApiDashboardRequest) =
            asdnAuthTokenProvider.getToken().flatMap { token ->
                token.takeIf { it.isPresent }?.let {
                    xapiDashboardRefreshWithASDN(it.get(), request)
                } ?: xapiDashboardRefresh(request)
            }

    private fun xapiDashboardRefresh(request: XApiDashboardRequest) =
            xApiService.getEntityRefresh(
                    request,
                    localeProvider.locale.iSO3Country,
                    localeProvider.locale.ngsdnLanguage.formatToXapi()
            )

    private fun xapiDashboardRefreshWithASDN(asdnAuthToken: String, request: XApiDashboardRequest) =
            xApiService.getEntityRefreshWithASDN(
                    request,
                    localeProvider.locale.iSO3Country,
                    localeProvider.locale.ngsdnLanguage.formatToXapi(),
                    asdnAuthToken
            )

    private fun String.formatToXapi() = this
            .split("-")
            .takeIf { it.size > 1 }
            ?.let { "${it[0]}-${it[1].toUpperCase(Locale.ROOT)}" }
            ?: this

}
