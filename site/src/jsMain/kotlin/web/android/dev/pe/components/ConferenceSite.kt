package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.navsite.LocalizedSite
import web.android.dev.pe.components.widgets.navsite.Navbar
import web.android.dev.pe.components.widgets.navsite.Navlink
import web.android.dev.pe.components.widgets.navsite.Navsite
import web.android.dev.pe.pages.home.components.sections.MainFooter

private val ConferenceNavbar = Navbar(
    links = listOf(
        Navlink(path = Res.Links.Conf.C4P) { ResStrings.conf_navlink_c4p },
        Navlink(path = Res.Links.Conf.SponsorBrief) { ResStrings.conf_navlink_sponsor },
        Navlink(path = "/about-us") { ResStrings.conf_navlink_about_us },
        Navlink(path = Res.Links.Conf.Register) { ResStrings.conf_navlink_register },
    ),
    logo = "/logo.svg",
    title = { ResStrings.conf_title }
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