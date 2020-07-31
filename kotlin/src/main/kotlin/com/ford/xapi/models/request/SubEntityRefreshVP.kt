package com.ford.xapi.models.request

data class SubEntityRefreshVP(
        @SerializedName("If-Modified-Since")
        val ifModifiedSince: String? = null,
        val refreshElement: String? = null
)