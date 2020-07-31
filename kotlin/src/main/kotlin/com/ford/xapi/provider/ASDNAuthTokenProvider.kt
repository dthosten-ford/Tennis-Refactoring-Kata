package com.ford.xapi.provider

import com.google.common.base.Optional
import io.reactivex.Single

interface ASDNAuthTokenProvider {
    fun getToken(): Single<Optional<String>>
}

