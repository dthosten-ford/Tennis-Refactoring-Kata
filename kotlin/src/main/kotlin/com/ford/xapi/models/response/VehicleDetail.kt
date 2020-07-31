package com.ford.xapi.models.response

@OpenForTesting
data class VehicleDetail(
        val userAuthStatus: XapiAuthStatus? = null,
        val VIN: String? = null,
        val isASDN: Boolean = false,
        val nickName: String? = null,
        val tcuEnabled: Boolean = false
)