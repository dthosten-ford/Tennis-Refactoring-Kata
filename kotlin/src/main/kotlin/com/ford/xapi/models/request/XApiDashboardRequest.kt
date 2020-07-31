package com.ford.xapi.models.request
import com.google.gson.annotations.SerializedName

data class XApiDashboardRequest(
        val dashboardRefreshRequest: String? = null,
        val entityRefresh: EntityRefresh? = null,
        val smsWakeUpVIN: String? = null
)

