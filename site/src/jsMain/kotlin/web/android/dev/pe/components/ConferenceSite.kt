package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.navsite.Navbar
import web.android.dev.pe.components.widgets.navsite.Navlink
import web.android.dev.pe.components.widgets.navsite.Navsite
import web.android.dev.pe.pages.home.components.sections.MainFooter

private val ConferenceNavbar = Navbar(
    links = listOf(
        Navlink("Call for Speakers", Res.Links.Conf.C4P),
        Navlink("Sponsors", Res.Links.Conf.SponsorBrief),
        Navlink("Quienes somos", "/about-us"),
    ),
    logo = "logo.svg",
    title = "Android Dev Peru Conf"
)

@Composable
fun ConferenceSite(content: @Composable () -> Unit) {
    Navsite(ConferenceNavbar) {
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