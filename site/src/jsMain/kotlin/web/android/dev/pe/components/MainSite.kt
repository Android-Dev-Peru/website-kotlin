package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.LanguageSelectorOptions
import web.android.dev.pe.components.widgets.navsite.*
import web.android.dev.pe.pages.home.components.sections.MainFooter

val MainSiteNavbar = Navbar(
    primaryLink = Navlink(path ="/subscribe") { ResStrings.site_navlink_subscribe },
    secondaryLinks = listOf(
        Navlink(path ="/about-us") { ResStrings.site_navlink_about_us },
        Navlink(path ="/resources") { ResStrings.site_navlink_resources },
        Navlink(path = "/conf") { ResStrings.site_navlink_conference },
    ),
    languageSelector = LanguageSelectorOptions.All,
    logo = NavbarLogo(
        src = "/logo.svg",
        title = { "Android Dev Peru" },
        path = "/",
    ),
)

@Composable
fun MainSite(lang: String, navbar: Navbar = MainSiteNavbar, content: @Composable () -> Unit) {
    LocalizedSite(navbar, lang) {
        Div(MainSiteStyle.toAttrs()) {
            content()
            MainFooter()
        }
    }
}

val MainSiteStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }
}

val CaptionStyle = Modifier
    .fontSize(14.px)
    .color(Res.Theme.TEXT.color)
    .textTransform(TextTransform.Uppercase)