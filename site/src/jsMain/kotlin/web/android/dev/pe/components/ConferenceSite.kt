package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.LanguageSelectorOptions
import web.android.dev.pe.components.widgets.navsite.*
import web.android.dev.pe.pages.home.components.sections.MainFooter

private val ConferenceNavbar = Navbar(
    primaryLink = Navlink(path = Res.Links.Conf.Register) { ResStrings.conf_navlink_register },
    secondaryLinks = listOf(
        Navlink(path = Res.Links.Conf.C4P) { ResStrings.conf_navlink_c4p },
        Navlink(path = "/conf/sponsorship") { ResStrings.conf_navlink_sponsor },
        Navlink(path = "/about-us") { ResStrings.conf_navlink_about_us },
        Navlink(path = "/conf/coc") { ResStrings.conf_navlink_code_of_conduct },
    ),
    languageSelector = LanguageSelectorOptions.All,
    logo = NavbarLogo(
        src = "/logo.svg",
        title = { ResStrings.conf_title },
        path = "/conf",
    ),

)

@Composable
fun ConferenceSite(lang: String, content: @Composable () -> Unit) {
    LocalizedSite(ConferenceNavbar, lang) {
        Div(ConferenceSiteStyle.toAttrs()) {
            content()
            MainFooter()
        }
    }
}

val ConferenceSiteStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }
}