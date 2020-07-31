package com.ford.locale.ServiceLocaleProvider

import com.google.common.base.Optional
import java.util.*


enum class ServiceLocale(private val regionLocale: Locale, val mSDNRegion: String, val ngsdnLanguage: String, val aSDNLanguage: String, val aSDNCountry: String, val scheduledStartDateFormat: String, val dealerSearchCountryCode: String, val weatherLanguage: String) {
//    CANADA(Locale.CANADA,
//            MSDNConstants.US_REGION,
//            NgsdnConstants.ENGLISH_US,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.CANADA,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.CANADA,
//            WeatherConstants.ENGLISH_UK),
//    CANADA_FRENCH(Locale.CANADA_FRENCH,
//            MSDNConstants.CANADA_REGION,
//            NgsdnConstants.FRENCH,
//            ASDNConstants.FRENCH,
//            ASDNConstants.CANADA,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.CANADA,
//            WeatherConstants.FRENCH),
//    US(Locale.US,
//            MSDNConstants.US_REGION,
//            NgsdnConstants.ENGLISH_US,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.US,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.US,
//            WeatherConstants.ENGLISH_US),
//    US_SPANISH(LocaleConstants.LOCALE_ES_US,
//            MSDNConstants.MEXICO_REGION,
//            NgsdnConstants.SPANISH_US,
//            ASDNConstants.SPANISH,
//            ASDNConstants.US,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.US,
//            WeatherConstants.SPANISH_US),
//    MEXICO(LocaleConstants.LOCALE_EN_MX,
//            MSDNConstants.US_REGION,
//            NgsdnConstants.ENGLISH_US,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.MEXICO,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.MEXICO,
//            WeatherConstants.ENGLISH_US),
//    MEXICO_SPANISH(LocaleConstants.LOCALE_ES_MX,
//            MSDNConstants.MEXICO_REGION,
//            NgsdnConstants.MEXICO_ES,
//            ASDNConstants.SPANISH,
//            ASDNConstants.MEXICO,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.MEXICO,
//            WeatherConstants.MEXICO_ES),
//    AP_AUSTRALIA(LocaleConstants.LOCALE_EN_AU,
//            MSDNConstants.AUSTRALIA_REGION,
//            NgsdnConstants.ENGLISH_AU,
//            ASDNConstants.AUSTRALIA,
//            ASDNConstants.AUSTRALIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.AUSTRALIA,
//            WeatherConstants.ENGLISH_AU),
//    AP_NEWZEALAND(LocaleConstants.LOCALE_EN_NZ,
//            MSDNConstants.NEWZEALAND_REGION,
//            NgsdnConstants.ENGLISH_NZ,
//            ASDNConstants.NEWZEALAND,
//            ASDNConstants.NEWZEALAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.NEWZEALAND,
//            WeatherConstants.ENGLISH_NZ),
//    AP_INDIA(LocaleConstants.LOCALE_EN_IN,
//            MSDNConstants.INDIA_REGION,
//            NgsdnConstants.ENGLISH_IN,
//            ASDNConstants.INDIA,
//            ASDNConstants.INDIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.INDIA,
//            WeatherConstants.ENGLISH_IN),
//    EU_ENGLISH(Locale.UK,
//            MSDNConstants.UK_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.UK,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.UK,
//            WeatherConstants.ENGLISH_UK),
//    EU_GERMAN(Locale.GERMANY,
//            MSDNConstants.GERMANY_REGION,
//            NgsdnConstants.GERMAN_DE,
//            ASDNConstants.GERMANY,
//            ASDNConstants.GERMANY,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.GERMANY,
//            WeatherConstants.GERMAN_DE),
//    EU_FRENCH(Locale.FRANCE,
//            MSDNConstants.FRANCE_REGION,
//            NgsdnConstants.FRENCH_FR,
//            ASDNConstants.FRENCH,
//            ASDNConstants.FRENCH,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.FRANCE,
//            WeatherConstants.FRENCH_FR),
//    EU_ITALY(Locale.ITALY,
//            MSDNConstants.ITALY_REGION,
//            NgsdnConstants.ITALY_IT,
//            ASDNConstants.ITALY,
//            ASDNConstants.ITALY,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ITALY,
//            WeatherConstants.ITALY_IT),
//    EU_SPAIN(LocaleConstants.LOCALE_ES,
//            MSDNConstants.SPAIN_REGION,
//            NgsdnConstants.SPAIN_ES,
//            ASDNConstants.SPAIN,
//            ASDNConstants.SPAIN,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SPAIN,
//            WeatherConstants.SPAIN_ES),
//    BR_PORTUGUESE(LocaleConstants.LOCALE_BR_PT,
//            MSDNConstants.BRAZIL_REGION,
//            NgsdnConstants.PORTUGUESE_BR,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.US,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.US,
//            WeatherConstants.PORTUGUESE_BR),
//    BR_ENGLISH(LocaleConstants.LOCALE_BR_EN,
//            MSDNConstants.BRAZIL_REGION,
//            NgsdnConstants.ENGLISH_US,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.US,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.US,
//            WeatherConstants.ENGLISH_UK),
//    AR_SPANISH(LocaleConstants.LOCALE_AR_ES,
//            MSDNConstants.ARGENTINA_REGION,
//            NgsdnConstants.SPANISH_AR,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.US,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.US,
//            WeatherConstants.SPANISH_AR),
//    AR_ENGLISH(LocaleConstants.LOCALE_AR_EN,
//            MSDNConstants.ARGENTINA_REGION,
//            NgsdnConstants.ENGLISH_US,
//            ASDNConstants.ENGLISH,
//            ASDNConstants.US,
//            NgsdnConstants.NA_SCHEDULED_START_FORMAT,
//            DealerConstants.US,
//            WeatherConstants.ENGLISH_UK),
//    EU_AUSTRIA(LocaleConstants.LOCALE_AT,
//            MSDNConstants.AUSTRIA_REGION,
//            NgsdnConstants.AUSTRIA_DE,
//            ASDNConstants.AUSTRIA,
//            ASDNConstants.AUSTRIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.AUSTRIA,
//            WeatherConstants.AUSTRIA_DE),
//    EU_BELGIUM_FR(LocaleConstants.LOCALE_BE_FR,
//            MSDNConstants.BELGIUM_REGION,
//            NgsdnConstants.BELGIUM_FR,
//            ASDNConstants.BELGIUM,
//            ASDNConstants.BELGIUM,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.BELGIUM,
//            WeatherConstants.BELGIUM_FR),
//    EU_BELGIUM_NL(LocaleConstants.LOCALE_BE_NL,
//            MSDNConstants.BELGIUM_REGION,
//            NgsdnConstants.BELGIUM_NL,
//            ASDNConstants.BELGIUM,
//            ASDNConstants.BELGIUM,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.BELGIUM,
//            WeatherConstants.BELGIUM_NL),
//    EU_BELGIUM_DE(LocaleConstants.LOCALE_BE_DE,
//            MSDNConstants.BELGIUM_REGION,
//            NgsdnConstants.BELGIUM_DE,
//            ASDNConstants.BELGIUM,
//            ASDNConstants.BELGIUM,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.BELGIUM,
//            WeatherConstants.BELGIUM_DE),
//    EU_CZECH_REPUBLIC(LocaleConstants.LOCALE_CZ,
//            MSDNConstants.CZECH_REPUBLIC_REGION,
//            NgsdnConstants.CZECH_REPUBLIC_CZ,
//            ASDNConstants.CZECH_REPUBLIC,
//            ASDNConstants.CZECH_REPUBLIC,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.CZECH_REPUBLIC,
//            WeatherConstants.CZECH_REPUBLIC_CZ),
//    EU_DENMARK(LocaleConstants.LOCALE_DK,
//            MSDNConstants.DENMARK_REGION,
//            NgsdnConstants.DENMARK_DN,
//            ASDNConstants.DENMARK,
//            ASDNConstants.DENMARK,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.DENMARK,
//            WeatherConstants.DENMARK_DN),
//    EU_FINLAND(LocaleConstants.LOCALE_FI,
//            MSDNConstants.FINLAND_REGION,
//            NgsdnConstants.FINLAND_FL,
//            ASDNConstants.FINLAND,
//            ASDNConstants.FINLAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.FINLAND,
//            WeatherConstants.FINLAND_FL),
//    EU_GREECE(LocaleConstants.LOCALE_GR,
//            MSDNConstants.GREECE_REGION,
//            NgsdnConstants.GREECE_EL,
//            ASDNConstants.GREECE,
//            ASDNConstants.GREECE,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.GREECE,
//            WeatherConstants.GREECE_EL),
//    EU_HUNGARY(LocaleConstants.LOCALE_HU,
//            MSDNConstants.HUNGARY_REGION,
//            NgsdnConstants.HUNGARY_HU,
//            ASDNConstants.HUNGARY,
//            ASDNConstants.HUNGARY,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.HUNGARY,
//            WeatherConstants.HUNGARY_HU),
//    EU_IRELAND(LocaleConstants.LOCALE_IE,
//            MSDNConstants.IRELAND_REGION,
//            NgsdnConstants.IRELAND_EN,
//            ASDNConstants.IRELAND,
//            ASDNConstants.IRELAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.IRELAND,
//            WeatherConstants.IRELAND_EN),
//    EU_NETHERLANDS(LocaleConstants.LOCALE_NL,
//            MSDNConstants.NETHERLANDS_REGION,
//            NgsdnConstants.NETHERLANDS_NL,
//            ASDNConstants.NETHERLANDS,
//            ASDNConstants.NETHERLANDS,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.NETHERLANDS,
//            WeatherConstants.NETHERLANDS_NL),
//    EU_NORWAY(LocaleConstants.LOCALE_NO,
//            MSDNConstants.NORWAY_REGION,
//            NgsdnConstants.NORWAY_NB,
//            ASDNConstants.NORWAY,
//            ASDNConstants.NORWAY,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.NORWAY,
//            WeatherConstants.NORWAY_NB),
//    EU_POLAND(LocaleConstants.LOCALE_PL,
//            MSDNConstants.POLAND_REGION,
//            NgsdnConstants.POLAND_PL,
//            ASDNConstants.POLAND,
//            ASDNConstants.POLAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.POLAND,
//            WeatherConstants.POLAND_PL),
//    EU_PORTUGAL(LocaleConstants.LOCALE_PT,
//            MSDNConstants.PORTUGAL_REGION,
//            NgsdnConstants.PORTUGAL_PT,
//            ASDNConstants.PORTUGAL,
//            ASDNConstants.PORTUGAL,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.PORTUGAL,
//            WeatherConstants.PORTUGAL_PT),
//    EU_ROMANIA(LocaleConstants.LOCALE_RO,
//            MSDNConstants.ROMANIA_REGION,
//            NgsdnConstants.ROMANIA_RO,
//            ASDNConstants.ROMANIA,
//            ASDNConstants.ROMANIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ROMANIA,
//            WeatherConstants.ROMANIA_RO),
//    EU_SWEDEN(LocaleConstants.LOCALE_SE,
//            MSDNConstants.SWEDEN_REGION,
//            NgsdnConstants.SWEDEN_SV,
//            ASDNConstants.SWEDEN,
//            ASDNConstants.SWEDEN,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SWEDEN,
//            WeatherConstants.SWEDEN_SV),
//    EU_SWITZERLAND_FR(LocaleConstants.LOCALE_CH_FR,
//            MSDNConstants.SWITZERLAND_REGION,
//            NgsdnConstants.SWITZERLAND_FR,
//            ASDNConstants.SWITZERLAND,
//            ASDNConstants.SWITZERLAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SWITZERLAND,
//            WeatherConstants.SWITZERLAND_FR),
//    EU_SWITZERLAND_DE(LocaleConstants.LOCALE_CH_DE,
//            MSDNConstants.SWITZERLAND_REGION,
//            NgsdnConstants.SWITZERLAND_DE,
//            ASDNConstants.SWITZERLAND,
//            ASDNConstants.SWITZERLAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SWITZERLAND,
//            WeatherConstants.SWITZERLAND_DE),
//    EU_SWITZERLAND_IT(LocaleConstants.LOCALE_CH_IT,
//            MSDNConstants.SWITZERLAND_REGION,
//            NgsdnConstants.SWITZERLAND_IT,
//            ASDNConstants.SWITZERLAND,
//            ASDNConstants.SWITZERLAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SWITZERLAND,
//            WeatherConstants.SWITZERLAND_IT),
//    EU_LUXEMBOURG_FR(LocaleConstants.LOCALE_LU_FR,
//            MSDNConstants.LUXEMBOURG_REGION,
//            NgsdnConstants.LUXEMBOURG_FR,
//            ASDNConstants.LUXEMBOURG,
//            ASDNConstants.LUXEMBOURG,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LUXEMBOURG,
//            WeatherConstants.LUXEMBOURG_FR),
//    EU_LUXEMBOURG_DE(LocaleConstants.LOCALE_LU_DE,
//            MSDNConstants.LUXEMBOURG_REGION,
//            NgsdnConstants.LUXEMBOURG_DE,
//            ASDNConstants.LUXEMBOURG,
//            ASDNConstants.LUXEMBOURG,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LUXEMBOURG,
//            WeatherConstants.LUXEMBOURG_DE),
//    EU_MALTA_EN(LocaleConstants.LOCALE_MT,
//            MSDNConstants.MALTA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.MALTA,
//            ASDNConstants.MALTA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.MALTA,
//            WeatherConstants.ENGLISH_UK),
//    EU_MALTA_IT(LocaleConstants.LOCALE_MT_IT,
//            MSDNConstants.MALTA_REGION,
//            NgsdnConstants.ITALY_IT,
//            ASDNConstants.MALTA,
//            ASDNConstants.MALTA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.MALTA,
//            WeatherConstants.ITALY_IT),
//    EU_BULGARIA_EN(LocaleConstants.LOCALE_BG,
//            MSDNConstants.BULGARIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.BULGARIA,
//            ASDNConstants.BULGARIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.BULGARIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_CROATIA_EN(LocaleConstants.LOCALE_HR,
//            MSDNConstants.CROATIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.CROATIA,
//            ASDNConstants.CROATIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.CROATIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_ESTONIA_EN(LocaleConstants.LOCALE_EE,
//            MSDNConstants.ESTONIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.ESTONIA,
//            ASDNConstants.ESTONIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ESTONIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_LATVIA_EN(LocaleConstants.LOCALE_LV,
//            MSDNConstants.LATVIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.LATVIA,
//            ASDNConstants.LATVIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LATVIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_LITHUANIA_EN(LocaleConstants.LOCALE_LT,
//            MSDNConstants.LITHUANIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.LITHUANIA,
//            ASDNConstants.LITHUANIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LITHUANIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_SLOVAKIA_EN(LocaleConstants.LOCALE_SK,
//            MSDNConstants.SLOVAKIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.SLOVAKIA,
//            ASDNConstants.SLOVAKIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SLOVAKIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_SLOVENIA_EN(LocaleConstants.LOCALE_SI,
//            MSDNConstants.SLOVENIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.SLOVENIA,
//            ASDNConstants.SLOVENIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SLOVENIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_SLOVENIA_SL(LocaleConstants.LOCALE_SL_SI,
//            MSDNConstants.SLOVENIA_REGION,
//            NgsdnConstants.SLOVENIA_SL,
//            ASDNConstants.SLOVENIA,
//            ASDNConstants.SLOVENIA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SLOVENIA,
//            WeatherConstants.ENGLISH_UK),
//    EU_ICELAND_EN(LocaleConstants.LOCALE_IS,
//            MSDNConstants.ICELAND_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.ICELAND,
//            ASDNConstants.ICELAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ICELAND,
//            WeatherConstants.ENGLISH_UK),
//    EU_ICELAND_DA(LocaleConstants.LOCALE_IS_DA,
//            MSDNConstants.ICELAND_REGION,
//            NgsdnConstants.DENMARK_DN,
//            ASDNConstants.ICELAND,
//            ASDNConstants.ICELAND,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ICELAND,
//            WeatherConstants.DENMARK_DN),
//    EU_CYPRUS_EN(LocaleConstants.LOCALE_CY,
//            MSDNConstants.CYPRUS_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.CYPRUS,
//            ASDNConstants.CYPRUS,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.CYPRUS,
//            WeatherConstants.ENGLISH_UK),
//    EU_CYPRUS_EL(LocaleConstants.LOCALE_CY_EL,
//            MSDNConstants.CYPRUS_REGION,
//            NgsdnConstants.GREECE_EL,
//            ASDNConstants.CYPRUS,
//            ASDNConstants.CYPRUS,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.CYPRUS,
//            WeatherConstants.CYPRUS_EL),
//    EU_LIECHTENSTEIN_DE(LocaleConstants.LOCALE_LI,
//            MSDNConstants.LIECHTENSTEIN_REGION,
//            NgsdnConstants.GERMAN_DE,
//            ASDNConstants.LIECHTENSTEIN,
//            ASDNConstants.LIECHTENSTEIN,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LIECHTENSTEIN,
//            WeatherConstants.GERMAN_DE),
//    EU_LIECHTENSTEIN_FR(LocaleConstants.LOCALE_LI_FR,
//            MSDNConstants.LIECHTENSTEIN_REGION,
//            NgsdnConstants.FRENCH_FR,
//            ASDNConstants.LIECHTENSTEIN,
//            ASDNConstants.LIECHTENSTEIN,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LIECHTENSTEIN,
//            WeatherConstants.FRENCH_FR),
//    EU_LIECHTENSTEIN_IT(LocaleConstants.LOCALE_LI_IT,
//            MSDNConstants.LIECHTENSTEIN_REGION,
//            NgsdnConstants.ITALY_IT,
//            ASDNConstants.LIECHTENSTEIN,
//            ASDNConstants.LIECHTENSTEIN,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LIECHTENSTEIN,
//            WeatherConstants.ITALY_IT),
//    EU_SAN_MARINO_IT(LocaleConstants.LOCALE_SM,
//            MSDNConstants.SAN_MARINO_REGION,
//            NgsdnConstants.GERMAN_DE,
//            ASDNConstants.SAN_MARINO,
//            ASDNConstants.SAN_MARINO,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SAN_MARINO,
//            WeatherConstants.ITALY_IT),
//    EU_MONACO_FR(LocaleConstants.LOCALE_MC,
//            MSDNConstants.MONACO_REGION,
//            NgsdnConstants.FRENCH_FR,
//            ASDNConstants.MONACO,
//            ASDNConstants.MONACO,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.MONACO,
//            WeatherConstants.MONACO_FR),
//    EU_ANDORRA_ES(LocaleConstants.LOCALE_AD,
//            MSDNConstants.ANDORRA_REGION,
//            NgsdnConstants.SPAIN_ES,
//            ASDNConstants.ANDORRA,
//            ASDNConstants.ANDORRA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ANDORRA,
//            WeatherConstants.ANDORRA_ES),
//    EU_GIBRALTAR_EN(LocaleConstants.LOCALE_GI,
//            MSDNConstants.GIBRALTAR_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.GIBRALTAR,
//            ASDNConstants.GIBRALTAR,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.GIBRALTAR,
//            WeatherConstants.ENGLISH_UK),
//    EU_GUERNSEY_EN(LocaleConstants.LOCALE_GG,
//            MSDNConstants.GUERNSEY_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.GUERNSEY,
//            ASDNConstants.GUERNSEY,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.GUERNSEY,
//            WeatherConstants.ENGLISH_UK),
//    EU_ISLE_OF_MAN_EN(LocaleConstants.LOCALE_IM,
//            MSDNConstants.ISLE_OF_MAN_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.ISLE_OF_MAN,
//            ASDNConstants.ISLE_OF_MAN,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ISLE_OF_MAN,
//            WeatherConstants.ENGLISH_UK),
//    EU_JERSEY_EN(LocaleConstants.LOCALE_JE,
//            MSDNConstants.JERSEY_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.JERSEY,
//            ASDNConstants.JERSEY,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.JERSEY,
//            WeatherConstants.ENGLISH_UK),
//    EU_FAEROE_ISLANDS_DA(LocaleConstants.LOCALE_FO,
//            MSDNConstants.FAEROE_ISLANDS_REGION,
//            NgsdnConstants.DENMARK_DN,
//            ASDNConstants.FAEROE_ISLANDS,
//            ASDNConstants.FAEROE_ISLANDS,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.FAEROE_ISLANDS,
//            WeatherConstants.DENMARK_DN),
//    ME_BH_EN(LocaleConstants.LOCALE_BH_EN,
//            MSDNConstants.BAHRAIN_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.BAHRAIN,
//            ASDNConstants.BAHRAIN,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.BAHRAIN,
//            WeatherConstants.ENGLISH_UK),
//    ME_BH_AR(LocaleConstants.LOCALE_BH_AR,
//            MSDNConstants.BAHRAIN_REGION,
//            NgsdnConstants.ARABIC_ME,
//            ASDNConstants.BAHRAIN,
//            ASDNConstants.BAHRAIN,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.BAHRAIN,
//            WeatherConstants.ARABIC_ME),
//    ME_KU_EN(LocaleConstants.LOCALE_KW_EN,
//            MSDNConstants.KUWAIT_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.KUWAIT,
//            ASDNConstants.KUWAIT,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.KUWAIT,
//            WeatherConstants.ENGLISH_UK),
//    ME_KU_AR(LocaleConstants.LOCALE_KW_AR,
//            MSDNConstants.KUWAIT_REGION,
//            NgsdnConstants.ARABIC_ME,
//            ASDNConstants.KUWAIT,
//            ASDNConstants.KUWAIT,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.KUWAIT,
//            WeatherConstants.ARABIC_ME),
//    ME_OM_EN(LocaleConstants.LOCALE_OM_EN,
//            MSDNConstants.OMAN_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.OMAN,
//            ASDNConstants.OMAN,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.OMAN,
//            WeatherConstants.ENGLISH_UK),
//    ME_OM_AR(LocaleConstants.LOCALE_OM_AR,
//            MSDNConstants.OMAN_REGION,
//            NgsdnConstants.ARABIC_ME,
//            ASDNConstants.OMAN,
//            ASDNConstants.OMAN,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.OMAN,
//            WeatherConstants.ARABIC_ME),
//    ME_QA_EN(LocaleConstants.LOCALE_QA_EN,
//            MSDNConstants.QATAR_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.QATAR,
//            ASDNConstants.QATAR,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.QATAR,
//            WeatherConstants.ENGLISH_UK),
//    ME_QA_AR(LocaleConstants.LOCALE_QA_AR,
//            MSDNConstants.QATAR_REGION,
//            NgsdnConstants.ARABIC_ME,
//            ASDNConstants.QATAR,
//            ASDNConstants.QATAR,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.QATAR,
//            WeatherConstants.ARABIC_ME),
//    ME_SA_EN(LocaleConstants.LOCALE_SA_EN,
//            MSDNConstants.SAUDI_ARABIA_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.SAUDI_ARABIA,
//            ASDNConstants.SAUDI_ARABIA,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.SAUDI_ARABIA,
//            WeatherConstants.ENGLISH_UK),
//    ME_SA_AR(LocaleConstants.LOCALE_SA_AR,
//            MSDNConstants.SAUDI_ARABIA_REGION,
//            NgsdnConstants.ARABIC_ME,
//            ASDNConstants.SAUDI_ARABIA,
//            ASDNConstants.SAUDI_ARABIA,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.SAUDI_ARABIA,
//            WeatherConstants.ARABIC_ME),
//    ME_UAE_EN(LocaleConstants.LOCALE_UAE_EN,
//            MSDNConstants.UAE_REGION,
//            NgsdnConstants.ENGLISH_UK,
//            ASDNConstants.UAE,
//            ASDNConstants.UAE,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.UAE,
//            WeatherConstants.ENGLISH_UK),
//    ME_UAE_AR(LocaleConstants.LOCALE_UAE_AR,
//            MSDNConstants.UAE_REGION,
//            NgsdnConstants.ARABIC_ME,
//            ASDNConstants.UAE,
//            ASDNConstants.UAE,
//            NgsdnConstants.ME_SCHEDULED_START_FORMAT,
//            DealerConstants.UAE,
//            WeatherConstants.ARABIC_ME),
//    IM_SOUTH_AFRICA(LocaleConstants.LOCALE_EN_ZA,
//            MSDNConstants.ZA_REGION,
//            NgsdnConstants.ENGLISH_ZA,
//            ASDNConstants.ZAF,
//            ASDNConstants.ZAF,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.ZAF,
//            WeatherConstants.ENGLISH_ZA),
//    IM_NAMIBIA(LocaleConstants.LOCALE_EN_NA,
//            MSDNConstants.NA_REGION,
//            NgsdnConstants.ENGLISH_ZA,
//            ASDNConstants.NAM,
//            ASDNConstants.NAM,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.NAM,
//            WeatherConstants.ENGLISH_ZA),
//    IM_BOTSWANA(LocaleConstants.LOCALE_EN_BW,
//            MSDNConstants.BW_REGION,
//            NgsdnConstants.ENGLISH_ZA,
//            ASDNConstants.BWA,
//            ASDNConstants.BWA,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.BWA,
//            WeatherConstants.ENGLISH_ZA),
//    IM_SWAZILAND(LocaleConstants.LOCALE_EN_SW,
//            MSDNConstants.SZ_REGION,
//            NgsdnConstants.ENGLISH_ZA,
//            ASDNConstants.SWZ,
//            ASDNConstants.SWZ,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.SWZ,
//            WeatherConstants.ENGLISH_ZA),
//    IM_LESOTHO(LocaleConstants.LOCALE_EN_LS,
//            MSDNConstants.LS_REGION,
//            NgsdnConstants.ENGLISH_ZA,
//            ASDNConstants.LSO,
//            ASDNConstants.LSO,
//            NgsdnConstants.EU_SCHEDULED_START_FORMAT,
//            DealerConstants.LSO,
//            WeatherConstants.ENGLISH_ZA);

    private var deviceLocale = Optional.absent<Locale>()
    fun setDeviceLocale(deviceLocale: Locale) {
        this.deviceLocale = Optional.of(deviceLocale)
    }

    val mSDNLanguage: String
        get() = regionLocale.language.toUpperCase()

    val mSDNIso3Language: String
        get() = regionLocale.isO3Language

    val iSO2Country: String
        get() = regionLocale.country

    val iSO3Country: String
        get() = regionLocale.isO3Country

    val osbISO3Country: String
        get() = if (iSO3Country == "ROU") "ROM" else iSO3Country

    fun getNgsdnLanguage(): String {
        return if (deviceLocale.isPresent) {
            deviceLocale.get().language + "-" + deviceLocale.get().country.toLowerCase()
        } else ngsdnLanguage
    }

    val csdnLanguage: String
        get() = if (deviceLocale.isPresent) {
            deviceLocale.get().language + "-" + deviceLocale.get().country.toUpperCase()
        } else ngsdnLanguage

    //================================================================================
    // Classes
    //================================================================================
    private object MSDNConstants {
        const val UK_REGION = "UK"
        const val GERMANY_REGION = "DE"
        const val FRANCE_REGION = "FR"
        const val ITALY_REGION = "IT"
        const val SPAIN_REGION = "ES"
        const val BRAZIL_REGION = "BR"
        const val ARGENTINA_REGION = "AR"
        private const val US_REGION = "US"
        private const val CANADA_REGION = "CA"
        private const val AUSTRIA_REGION = "AT"
        private const val BELGIUM_REGION = "BE"
        private const val CZECH_REPUBLIC_REGION = "CZ"
        private const val DENMARK_REGION = "DK"
        private const val FINLAND_REGION = "FI"
        private const val GREECE_REGION = "GR"
        private const val HUNGARY_REGION = "HU"
        private const val IRELAND_REGION = "IE"
        private const val NETHERLANDS_REGION = "NL"
        private const val NORWAY_REGION = "NO"
        private const val POLAND_REGION = "PL"
        private const val PORTUGAL_REGION = "PT"
        private const val ROMANIA_REGION = "RO"
        private const val SWEDEN_REGION = "SE"
        private const val SWITZERLAND_REGION = "CH"
        private const val LUXEMBOURG_REGION = "LU"
        private const val MEXICO_REGION = "MX"
        private const val AUSTRALIA_REGION = "AU"
        private const val NEWZEALAND_REGION = "NZ"
        private const val INDIA_REGION = "IN"
        private const val MALTA_REGION = "MT"
        private const val BULGARIA_REGION = "BG"
        private const val CROATIA_REGION = "HR"
        private const val ESTONIA_REGION = "EE"
        private const val LATVIA_REGION = "LV"
        private const val LITHUANIA_REGION = "LT"
        private const val SLOVAKIA_REGION = "SK"
        private const val SLOVENIA_REGION = "SI"
        private const val ICELAND_REGION = "IS"
        private const val CYPRUS_REGION = "CY"
        private const val LIECHTENSTEIN_REGION = "LI"
        private const val SAN_MARINO_REGION = "SM"
        private const val MONACO_REGION = "MC"
        private const val ANDORRA_REGION = "AD"
        private const val GIBRALTAR_REGION = "GI"
        private const val GUERNSEY_REGION = "GG"
        private const val ISLE_OF_MAN_REGION = "IM"
        private const val JERSEY_REGION = "JE"
        private const val FAEROE_ISLANDS_REGION = "FO"
        private const val BAHRAIN_REGION = "BH"
        private const val KUWAIT_REGION = "KW"
        private const val OMAN_REGION = "OM"
        private const val QATAR_REGION = "QA"
        private const val SAUDI_ARABIA_REGION = "SA"
        private const val UAE_REGION = "AE"
        private const val ZA_REGION = "ZA"
        private const val NA_REGION = "NA"
        private const val BW_REGION = "BW"
        private const val SZ_REGION = "SZ"
        private const val LS_REGION = "LS"
    }

    private object NgsdnConstants {
        const val ENGLISH_UK = "en-gb"
        const val GERMAN_DE = "de-de"
        const val FRENCH_FR = "fr-fr"
        const val ITALY_IT = "it-it"
        const val SPAIN_ES = "es-es"
        const val PORTUGUESE_BR = "pt-br"
        const val SPANISH_AR = "es-ar"
        const val EU_SCHEDULED_START_FORMAT = "M-dd-yyyy h:mm:ss a"
        private const val ENGLISH_US = "en-us"
        private const val FRENCH = "fr-ca"
        private const val AUSTRIA_DE = "de-at"
        private const val BELGIUM_FR = "fr-be"
        private const val BELGIUM_NL = "nl-be"
        private const val BELGIUM_DE = "de-be"
        private const val CZECH_REPUBLIC_CZ = "cs-cz"
        private const val DENMARK_DN = "da-DK"
        private const val FINLAND_FL = "fi-FI"
        private const val GREECE_EL = "el-gr"
        private const val HUNGARY_HU = "hu-hu"
        private const val IRELAND_EN = "en-ie"
        private const val NETHERLANDS_NL = "nl-nl"
        private const val NORWAY_NB = "nb-no"
        private const val POLAND_PL = "pl-pl"
        private const val PORTUGAL_PT = "pt-pt"
        private const val ROMANIA_RO = "ro-ro"
        private const val SWEDEN_SV = "sv-se"
        private const val SLOVENIA_SL = "sl-si"
        private const val SWITZERLAND_FR = "fr-ch"
        private const val SWITZERLAND_DE = "de-ch"
        private const val SWITZERLAND_IT = "it-ch"
        private const val LUXEMBOURG_FR = "fr-lu"
        private const val LUXEMBOURG_DE = "de-lu"
        private const val MEXICO_ES = "es-mx"
        private const val ENGLISH_AU = "en-au"
        private const val ENGLISH_NZ = "en-nz"
        private const val ENGLISH_IN = "en-in"
        private const val SPANISH_US = "es-us"
        private const val ARABIC_ME = "ar-ae"
        private const val NA_SCHEDULED_START_FORMAT = "M-dd-yyyy h:mm:ss a"
        private const val AP_SCHEDULED_START_FORMAT = "M-dd-yyyy a h:mm:ss"
        private const val ME_SCHEDULED_START_FORMAT = "M-dd-yyyy a h:mm:ss"
        private const val ENGLISH_ZA = "en-za"
    }

    private object WeatherConstants {
        private const val ENGLISH_US = "en-us"
        private const val FRENCH = "fr-ca"
        private const val ENGLISH_UK = "en-gb"
        private const val GERMAN_DE = "de-de"
        private const val FRENCH_FR = "fr-fr"
        private const val ITALY_IT = "it-it"
        private const val SPAIN_ES = "es-es"
        private const val PORTUGUESE_BR = "pt-br"
        private const val SPANISH_AR = "es-ar"
        private const val AUSTRIA_DE = "de-at"
        private const val BELGIUM_FR = "fr-be"
        private const val BELGIUM_NL = "nl-be"
        private const val BELGIUM_DE = "de-be"
        private const val CZECH_REPUBLIC_CZ = "cs-cz"
        private const val DENMARK_DN = "da-DK"
        private const val FINLAND_FL = "fi-FI"
        private const val GREECE_EL = "el-gr"
        private const val HUNGARY_HU = "hu-hu"
        private const val IRELAND_EN = "en-ie"
        private const val NETHERLANDS_NL = "nl-nl"
        private const val NORWAY_NB = "nb-no"
        private const val POLAND_PL = "pl-pl"
        private const val PORTUGAL_PT = "pt-pt"
        private const val ROMANIA_RO = "ro-ro"
        private const val SWEDEN_SV = "sv-se"
        private const val SWITZERLAND_FR = "fr-ch"
        private const val SWITZERLAND_DE = "de-ch"
        private const val SWITZERLAND_IT = "it-ch"
        private const val LUXEMBOURG_FR = "fr-lu"
        private const val LUXEMBOURG_DE = "de-lu"
        private const val MEXICO_ES = "es-mx"
        private const val ENGLISH_AU = "en-au"
        private const val ENGLISH_NZ = "en-nz"
        private const val ENGLISH_IN = "en-in"
        private const val SPANISH_US = "es-us"
        private const val CYPRUS_EL = "el-el"
        private const val MONACO_FR = "fr-mc"
        private const val ANDORRA_ES = "es-ad"
        private const val ARABIC_ME = "ar-ae"
        private const val ENGLISH_ZA = "en-za"
    }

    private object ASDNConstants {
        const val UK = "W_COUNTRY_UK"
        const val GERMANY = "W_COUNTRY_GERMANY"
        const val ITALY = "W_COUNTRY_ITALY"
        const val SPAIN = "W_COUNTRY_SPAIN"
        private const val ENGLISH = "W_LANG_EN"
        private const val FRENCH = "W_LANG_FR"
        private const val SPANISH = "W_LANG_ES"
        private const val US = "W_COUNTRY_US"
        private const val CANADA = "W_COUNTRY_CA"
        private const val AUSTRIA = "W_COUNTRY_AUSTRIA"
        private const val BELGIUM = "W_COUNTRY_BELGIUM"
        private const val CZECH_REPUBLIC = "W_COUNTRY_CZECH_REPUBLIC"
        private const val DENMARK = "W_COUNTRY_DENMARK"
        private const val FINLAND = "W_COUNTRY_FINLAND"
        private const val GREECE = "W_COUNTRY_GREECE"
        private const val HUNGARY = "W_COUNTRY_HUNGARY"
        private const val IRELAND = "W_COUNTRY_IRELAND"
        private const val NETHERLANDS = "W_COUNTRY_NETHERLANDS"
        private const val NORWAY = "W_COUNTRY_NORWAY"
        private const val POLAND = "W_COUNTRY_POLAND"
        private const val PORTUGAL = "W_COUNTRY_PORTUGAL"
        private const val ROMANIA = "W_COUNTRY_ROMANIA"
        private const val SWEDEN = "W_COUNTRY_SWEDEN"
        private const val SWITZERLAND = "W_COUNTRY_SWITZERLAND"
        private const val LUXEMBOURG = "W_COUNTRY_LUXEMBOURG"
        private const val MEXICO = "W_COUNTRY_MEXICO"
        private const val AUSTRALIA = "W_COUNTRY_AUSTRALIA"
        private const val NEWZEALAND = "W_COUNTRY_NEWZEALAND"
        private const val MALTA = "W_COUNTRY_MALTA"
        private const val BULGARIA = "W_COUNTRY_BULGARIA"
        private const val CROATIA = "W_COUNTRY_CROATIA"
        private const val ESTONIA = "W_COUNTRY_ESTONIA"
        private const val LATVIA = "W_COUNTRY_LATVIA"
        private const val LITHUANIA = "W_COUNTRY_LITHUANIA"
        private const val SLOVAKIA = "W_COUNTRY_SLOVAKIA"
        private const val SLOVENIA = "W_COUNTRY_SLOVENIA"
        private const val ICELAND = "W_COUNTRY_ICELAND"
        private const val INDIA = "W_COUNTRY_INDIA"
        private const val CYPRUS = "W_COUNTRY_CYPRUS"
        private const val LIECHTENSTEIN = "W_COUNTRY_LIECHTENSTEIN"
        private const val SAN_MARINO = "W_COUNTRY_SAN_MARINO"
        private const val MONACO = "W_COUNTRY_MONACO"
        private const val ANDORRA = "W_COUNTRY_ANDORRA"
        private const val GIBRALTAR = "W_COUNTRY_GIBRALTAR"
        private const val GUERNSEY = "W_COUNTRY_GUERNSEY"
        private const val ISLE_OF_MAN = "W_COUNTRY_ISLE_OF_MAN"
        private const val JERSEY = "W_COUNTRY_JERSEY"
        private const val FAEROE_ISLANDS = "W_COUNTRY_FAEROE_ISLANDS"
        private const val BAHRAIN = "W_COUNTRY_BAHRAIN"
        private const val KUWAIT = "KW_COUNTRY_KUWAIT"
        private const val OMAN = "W_COUNTRY_OMAN"
        private const val QATAR = "W_COUNTRY_QATAR"
        private const val SAUDI_ARABIA = "W_COUNTRY_SAUDI_ARABIA"
        private const val UAE = "W_COUNTRY_UAE"
        private const val ZAF = "W_COUNTRY_ZAF"
        private const val NAM = "W_COUNTRY_NAM"
        private const val BWA = "W_COUNTRY_BWA"
        private const val SWZ = "W_COUNTRY_SWZ"
        private const val LSO = "W_COUNTRY_LSO"
    }

    private object DealerConstants {
        private const val US = "US"
        private const val CANADA = "CAN"
        private const val UK = "UK"
        private const val GERMANY = "DE"
        private const val FRANCE = "FR"
        private const val ITALY = "IT"
        private const val SPAIN = "ES"
        private const val AUSTRIA = "AT"
        private const val BELGIUM = "BE"
        private const val CZECH_REPUBLIC = "CZ"
        private const val DENMARK = "DK"
        private const val FINLAND = "FI"
        private const val GREECE = "GR"
        private const val HUNGARY = "HU"
        private const val IRELAND = "IE"
        private const val NETHERLANDS = "NL"
        private const val NORWAY = "NO"
        private const val POLAND = "PL"
        private const val PORTUGAL = "PT"
        private const val ROMANIA = "RO"
        private const val SWEDEN = "SE"
        private const val SWITZERLAND = "CH"
        private const val LUXEMBOURG = "LU"
        private const val MEXICO = "MX"
        private const val AUSTRALIA = "AU"
        private const val NEWZEALAND = "NZ"
        private const val MALTA = "MT"
        private const val BULGARIA = "BG"
        private const val CROATIA = "HR"
        private const val ESTONIA = "EE"
        private const val LATVIA = "LV"
        private const val LITHUANIA = "LT"
        private const val SLOVAKIA = "SK"
        private const val SLOVENIA = "SI"
        private const val ICELAND = "IS"
        private const val INDIA = "IN"
        private const val CYPRUS = "CY"
        private const val LIECHTENSTEIN = "LI"
        private const val SAN_MARINO = "SM"
        private const val MONACO = "MC"
        private const val ANDORRA = "AD"
        private const val GIBRALTAR = "GI"
        private const val GUERNSEY = "GG"
        private const val ISLE_OF_MAN = "IM"
        private const val JERSEY = "JE"
        private const val FAEROE_ISLANDS = "FO"
        private const val BAHRAIN = "BH"
        private const val KUWAIT = "KW"
        private const val OMAN = "OM"
        private const val QATAR = "QA"
        private const val SAUDI_ARABIA = "SA"
        private const val UAE = "AE"
        private const val ZAF = "ZA"
        private const val NAM = "NA"
        private const val BWA = "BW"
        private const val LSO = "LS"
        private const val SWZ = "SZ"
    }

    object LocaleConstants {
        val LOCALE_ES = Locale("es", "ES")
        val LOCALE_BR_EN = Locale("en", "BR")
        val LOCALE_BR_PT = Locale("pt", "BR")
        val LOCALE_AR_ES = Locale("es", "AR")
        val LOCALE_AR_EN = Locale("en", "AR")
        val LOCALE_AT = Locale("de", "AT")
        val LOCALE_BE = Locale("en", "BE")
        val LOCALE_BE_FR = Locale("fr", "BE")
        val LOCALE_BE_NL = Locale("nl", "BE")
        val LOCALE_BE_DE = Locale("de", "BE")
        val LOCALE_CZ = Locale("cs", "CZ")
        val LOCALE_DK = Locale("da", "dk")
        val LOCALE_FI = Locale("fi", "FI")
        val LOCALE_GR = Locale("el", "GR")
        val LOCALE_HU = Locale("hu", "HU")
        val LOCALE_IE = Locale("en", "IE")
        val LOCALE_NL = Locale("nl", "NL")
        val LOCALE_NO = Locale("no", "NO")
        val LOCALE_PL = Locale("pl", "PL")
        val LOCALE_PT = Locale("pt", "PT")
        val LOCALE_RO = Locale("ro", "RO")
        val LOCALE_SE = Locale("sv", "SE")
        val LOCALE_CH = Locale("en", "CH")
        val LOCALE_CH_FR = Locale("fr", "CH")
        val LOCALE_CH_DE = Locale("de", "CH")
        val LOCALE_CH_IT = Locale("it", "CH")
        val LOCALE_LU = Locale("en", "LU")
        val LOCALE_LU_FR = Locale("fr", "LU")
        val LOCALE_LU_DE = Locale("de", "LU")
        val LOCALE_ES_MX = Locale("es", "MX")
        val LOCALE_EN_MX = Locale("en", "MX")
        val LOCALE_EN_AU = Locale("en", "AU")
        val LOCALE_EN_NZ = Locale("en", "NZ")
        val LOCALE_EN_IN = Locale("en", "IN")
        val LOCALE_ES_US = Locale("es", "US")
        val LOCALE_MT = Locale("en", "MT")
        val LOCALE_MT_IT = Locale("it", "MT")
        val LOCALE_BG = Locale("en", "BG")
        val LOCALE_BG_BG = Locale("bg", "BG")
        val LOCALE_HR = Locale("en", "HR")
        val LOCALE_EE = Locale("en", "EE")
        val LOCALE_LV = Locale("en", "LV")
        val LOCALE_LT = Locale("en", "LT")
        val LOCALE_SK = Locale("en", "SK")
        val LOCALE_SI = Locale("en", "SI")
        val LOCALE_SL_SI = Locale("sl", "SI")
        val LOCALE_IS = Locale("en", "IS")
        val LOCALE_IS_DA = Locale("da", "IS")
        val LOCALE_CY = Locale("en", "CY")
        val LOCALE_CY_EL = Locale("el", "CY")
        val LOCALE_LI = Locale("de", "LI")
        val LOCALE_LI_FR = Locale("fr", "LI")
        val LOCALE_LI_IT = Locale("it", "LI")
        val LOCALE_SM = Locale("it", "SM")
        val LOCALE_MC = Locale("fr", "MC")
        val LOCALE_AD = Locale("es", "AD")
        val LOCALE_GI = Locale("en", "GI")
        val LOCALE_GG = Locale("en", "GG")
        val LOCALE_IM = Locale("en", "IM")
        val LOCALE_JE = Locale("en", "JE")
        val LOCALE_FO = Locale("da", "FO")
        val LOCALE_BH_AR = Locale("ar", "BH")
        val LOCALE_BH_EN = Locale("en", "BH")
        val LOCALE_KW_AR = Locale("ar", "KW")
        val LOCALE_KW_EN = Locale("en", "KW")
        val LOCALE_OM_AR = Locale("ar", "OM")
        val LOCALE_OM_EN = Locale("en", "OM")
        val LOCALE_QA_AR = Locale("ar", "QA")
        val LOCALE_QA_EN = Locale("en", "QA")
        val LOCALE_SA_AR = Locale("ar", "SA")
        val LOCALE_SA_EN = Locale("en", "SA")
        val LOCALE_UAE_AR = Locale("ar", "AE")
        val LOCALE_UAE_EN = Locale("en", "AE")
        val LOCALE_EN_ZA = Locale("en", "ZA")
        val LOCALE_EN_NA = Locale("en", "NA")
        val LOCALE_EN_BW = Locale("en", "BW")
        val LOCALE_EN_SW = Locale("en", "SZ")
        val LOCALE_EN_LS = Locale("en", "LS")
    }

    companion object {
        fun findByAndroidLocale(locale: Locale): ServiceLocale? {
            for (serviceLocale in com.ford.locale.ServiceLocale.values()) {
                if (serviceLocale.regionLocale == locale) {
                    return serviceLocale
                }
            }
            return null
        }

        fun getISO3CountryCode(countryName: String?): String? {
            for (serviceLocale in com.ford.locale.ServiceLocale.values()) {
                if (serviceLocale.regionLocale.getDisplayCountry(Locale.US).equals(countryName, ignoreCase = true)) {
                    return serviceLocale.iSO3Country
                }
            }
            return null
        }
    }

}
