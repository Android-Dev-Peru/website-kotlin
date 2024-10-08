package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import strings.ResStrings
import web.android.dev.pe.Theme
import web.android.dev.pe.components.utils.getCurrentLanguageFromPath
import web.android.dev.pe.components.utils.isRoot
import web.android.dev.pe.get

enum class Language(val code: String, val locale: String) {
    Spanish("es", "es_PE"),
    English("en", "en_US");

    val title get() = when(this) {
        Spanish -> ResStrings.language_option_es
        English -> ResStrings.language_option_en
    }

    companion object {
        val DefaultLanguage = Spanish
    }
}

enum class LanguageSelectorOptions { All, None }

@Composable
fun LanguageSelector(
    options: LanguageSelectorOptions,
    modifier: Modifier = Modifier,
) {
    if (options == LanguageSelectorOptions.None) {
        return
    }
    Div(LanguageSelectorStyle.toModifier().then(modifier).toAttrs()) {
        Select({
            onChange { navigateToLanguage(it.value) }
            classes("select-box")
        }) {
            sortedLanguages.forEach { language ->
                Option(value = language.code) {
                    SpanText(language.title, LanguageSelectorStyle.toModifier())
                }
            }
        }
    }
}

private val sortedLanguages get(): List<Language> {
    val currentLanguage = getCurrentLanguageFromPath()
    val sortedLanguagesExcludingCurrent = Language.entries.filter { it != currentLanguage }.sortedBy { it.title }
    return listOf(currentLanguage) + sortedLanguagesExcludingCurrent
}

private fun navigateToLanguage(languageCode: String?) {
    if (languageCode == null) {
        return // no language selected
    }

    val currentLanguage = getCurrentLanguageFromPath().code
    if (languageCode == currentLanguage) {
        return // no language change
    }

    if (isRoot()) {
        window.location.href = languageCode
        return
    }

    val pathWithoutLanguage = window.location.href.removeSuffix("/$currentLanguage")
    val targetPath = when (languageCode) {
        Language.DefaultLanguage.code -> pathWithoutLanguage
        else -> "$pathWithoutLanguage/${languageCode}"
    }

    window.location.href = targetPath
}

val LanguageSelectorStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .position(Position.Relative)
    }
    cssRule(" select") {
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .fontFamily("Google Sans", "sans-serif")
            .backgroundColor(colorMode.get(Theme.navbar))
            .border(0.px)
            .cursor(Cursor.Pointer)
            .padding(leftRight = 8.px)
            .fontSize(14.px)
            .color(colorMode.get(Theme.onSurface))
    }
}
