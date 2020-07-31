package com.ford.xapi.models.response

data class VehicleProfile(
        val VIN: String? = null,
        val displaySmartCharging: String? = null,
        val make: String? = null,
        val model: String? = null,
        val productType: String? = null,
        val sdn: String? = null,
        val showEVBatteryLevel: Boolean? = false,
        val showFuelLevel: Boolean? = false,
        val status: Status? = Status(),
        val vehicleImage: String? = null,
        val year: String? = null,
        val doubleLocking: String? = null,
        val alarmFunctionality: String? = null
)