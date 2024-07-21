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
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.navsite.Navbar
import web.android.dev.pe.components.widgets.navsite.Navlink
import web.android.dev.pe.components.widgets.navsite.Navsite

private val ConferenceNavbar = Navbar(
    links = listOf(
        Navlink("Call for papers", Res.Links.Conf.C4P),
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
        }
    }
}

val ConferenceSiteStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }

    cssRule(" span") {
        Modifier
            .fontSize(14.px)
            .color(Res.Theme.TEXT.color)
            .textTransform(TextTransform.Uppercase)
    }
}