package com.ford.locale.ServiceLocaleProvider

import java.util.*

interface ServiceLocaleProvider {
    val locale: ServiceLocale?
    val deviceLanguage: String?
    val applicationDisplayLanguage: String?
    val aemDeviceLanguage: String?

    fun getApplicationLocale(deviceLocale: Locale, defaultLocale: Locale?, regionSupportedLocales: List<Locale>): Locale? {
//        for (supportedLocale in regionSupportedLocales) {
//            if (deviceLocale.toString() == supportedLocale.toString()) return supportedLocale
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            for (supportedLocale in regionSupportedLocales) {
//                if (deviceLocale.language == supportedLocale.language) return supportedLocale
//            }
//        }
        return defaultLocale
    }

    val systemLocale: Locale?
        get() = Locale.getDefault()
}
