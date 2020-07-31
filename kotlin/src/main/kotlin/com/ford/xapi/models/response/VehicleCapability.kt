package com.ford.xapi.models.response

@Entity(tableName = "vehicle_capabilities_table")
@TypeConverters(StatusConverter::class, XapiAuthStatusConverter::class)
data class VehicleCapability(
        @PrimaryKey
        val VIN: String,
        val extendRemoteStart: String? = null,
        val getDtcsViaApplink: String? = null,
        val paak: String? = null,
        val remoteLock: String? = null,
        val remoteStart: String? = null,
        val smartCharge: String? = null,
        val status: Status? = Status(),
        val trailerLightCheck: String? = null,
        val userAuthStatus: XapiAuthStatus? = null,
        val displayOTAStatusReport: String? = null,
        val remoteHeatingCooling: String? = null
) {
    var timeStamp: Long = -1L
}