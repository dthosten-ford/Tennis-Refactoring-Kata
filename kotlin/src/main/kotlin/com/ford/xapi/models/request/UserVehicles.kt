package com.ford.xapi.models.request

data class UserVehicles(
        @SerializedName("If-Modified-Since")
        val ifModifiedSince: String? = null
)