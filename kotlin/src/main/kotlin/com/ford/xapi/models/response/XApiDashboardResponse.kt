package com.ford.xapi.models.response

import com.ford.xapi.models.request.UserVehicles

data class XApiDashboardResponse(
        val userVehicles: UserVehicles? = UserVehicles(UserVehicles.DATABASE_KEY, vehicleDetails = listOf()),
        val vehicleCapabilities: List<VehicleCapability?>? = listOf(),
        val vehicleProfile: List<VehicleProfile?>? = listOf(),
        val vehicleRecall: List<VehicleRecall?>? = listOf()
)

