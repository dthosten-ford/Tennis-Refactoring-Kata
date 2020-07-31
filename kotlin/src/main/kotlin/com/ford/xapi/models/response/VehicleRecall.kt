package com.ford.xapi.models.response

data class VehicleRecall(
        val VIN: String? = null,
        @SerializedName("numberofRecall")
        val numberOfRecall: Int? = null,
        @SerializedName("numberofFSA")
        val numberOfFSA: Int? = null,
        val status: Status? = null
)