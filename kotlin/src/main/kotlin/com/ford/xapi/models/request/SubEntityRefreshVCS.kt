package com.ford.xapi.models.request

data class SubEntityRefreshVCS(
        @SerializedName("If-Modified-Since")
        val ifModifiedSince: String? = null,
        val refreshElement: String? = null,
        val isASDN: Boolean? = null
)