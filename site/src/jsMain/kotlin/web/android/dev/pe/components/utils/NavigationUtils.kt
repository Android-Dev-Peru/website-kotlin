package web.android.dev.pe.components.utils

import kotlinx.browser.window
import web.android.dev.pe.components.widgets.Language

fun isRoot() = window.location.pathname.equals("/")

fun getCurrentLanguageFromPath(): Language {
    return when(window.location.pathname.substringAfterLast("/")) {
        Language.English.code -> Language.English
        else -> Language.DefaultLanguage
    }
}

fun String.appendCurrentLanguage(): String {
    val currentLanguage = getCurrentLanguageFromPath().code
    return if (currentLanguage == Language.DefaultLanguage.code) {
        this
    } else {
        if (this == "/") "/$currentLanguage" else "$this/$currentLanguage"
    }
}