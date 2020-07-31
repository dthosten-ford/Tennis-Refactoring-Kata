package `package com`.ford.xapi.services


import com.ford.xapi.models.request.XApiDashboardRequest
import com.ford.xapi.models.response.XApiDashboardResponse
import io.reactivex.Single
import retrofit2.http.*

class XApiService {
    @POST("v1/details")
    fun getEntityRefresh(
            @Body request: XApiDashboardRequest,
            @Header("countryCode") country: String,
            @Header("locale") locale: String) : Single<XApiDashboardResponse>

    @POST("v1/details")
    fun getEntityRefreshWithASDN(
            @Body request: XApiDashboardRequest,
            @Header("countryCode") country: String,
            @Header("locale") locale: String,
            @Header("ASDN-token") asdnToken: String) : Single<XApiDashboardResponse>
}
