package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.Routes
import web.android.dev.pe.components.widgets.LanguageSelectorOptions
import web.android.dev.pe.components.widgets.navsite.*
import web.android.dev.pe.pages.home.components.sections.MainFooter

private val ConferenceNavbar = Navbar(
//    primaryLink = Navlink(path = Res.Links.Conf.Register) { ResStrings.conf_navlink_register },
    primaryLink = null,
    secondaryLinks = listOf(
        Navlink(path = Res.Links.Conf.C4P, localizablePath = false) { ResStrings.conf_navlink_c4p },
        Navlink(path = Routes.Conf.Sponsorship) { ResStrings.conf_navlink_sponsor },
    ),
    languageSelector = LanguageSelectorOptions.All,
    logo = NavbarLogo(
        src = "/logo.svg",
        title = { ResStrings.conf_title },
        path = Routes.Conf.Index,
    ),

)

@Composable
fun ConferenceSite(lang: String, content: @Composable () -> Unit) {
    LocalizedSite(ConferenceNavbar, lang) {
        Div(ConferenceSiteStyle.toAttrs()) {
            content()
            MainFooter(extraLinks = listOf(
                Navlink(path = Routes.AboutUs) { ResStrings.conf_navlink_about_us },
                Navlink(path = Routes.Conf.CodeOfConduct) { ResStrings.conf_navlink_code_of_conduct },
            ))
        }
    }
}

val ConferenceSiteStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }
}