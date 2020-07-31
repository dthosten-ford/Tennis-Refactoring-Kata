package com.ford.xapi.models.response

data class Status(
        @SerializedName("cache-control")
        val cache_control: String? = null,
        val errorDetails: String? = null,
        val last_modified: String? = null,
        val statusCode: String? = null
)