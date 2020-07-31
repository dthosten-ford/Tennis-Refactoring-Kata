package com.ford.xapi.provider

interface XApiLogoutEventProvider {
    fun doOnLogout(onLogoutEvent: () -> Unit)
}