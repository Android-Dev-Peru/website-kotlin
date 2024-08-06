package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Option
import org.jetbrains.compose.web.dom.Select
import strings.ResStrings
import web.android.dev.pe.Res

enum class Language(val code: String) {
    Spanish("es"),
    English("en");

    val title get() = when(this) {
        Spanish -> ResStrings.language_option_es
        English -> ResStrings.language_option_en
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

private fun getCurrentLanguageFromPath(): Language {
    return when(window.location.pathname.substringAfterLast("/")) {
        Language.English.code -> Language.English
        else -> Language.Spanish
    }
}

private fun navigateToLanguage(languageCode: String?) {
    if (languageCode == null) {
        return // no language selected
    }

    val currentLanguage = getCurrentLanguageFromPath().code
    if (languageCode == currentLanguage) {
        return // no language change
    }

    val pathWithoutLanguage = window.location.pathname.removeSuffix("/$currentLanguage")
    val targetPath = when (languageCode) {
        Language.Spanish.code -> pathWithoutLanguage // Spanish is the default language
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
            .border(0.px)
            .cursor(Cursor.Pointer)
            .padding(leftRight = 8.px)
            .fontSize(FontSize.Inherit)
            .color(Res.Theme.TEXT.color)
    }
}
