package com.ford.xapi.models.request

data class EntityRefresh(
        val subEntityRefreshVCS: List<SubEntityRefreshVCS>? = null,
        val subEntityRefreshVP: List<SubEntityRefreshVP>? = null,
        val subEntityRefreshVehicleRecall: List<SubEntityRefreshVehicleRecall>? = null,
        val userVehicles: UserVehicles? = null,
        val vehicleCapabilities: String? = null,
        val vehicleProfile: String? = null,
        val vehicleRecall: String? = null
)