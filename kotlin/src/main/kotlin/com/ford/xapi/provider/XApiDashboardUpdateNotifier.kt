package com.ford.xapi.provider

import com.ford.xapi.models.response.XApiDashboardResponse

interface XApiDashboardUpdateNotifier {
    fun getDashbaordUpdateNotifier(): Observable<XApiDashboardResponse>
}


