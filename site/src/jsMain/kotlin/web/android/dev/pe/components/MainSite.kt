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

private val MainSiteNavbar = Navbar(
    links = listOf(
        Navlink("Conferencia", "/conf"),
        Navlink("Ubicación", "/conf/"),
        Navlink("Call for papers", "/conf/sponsor"),
        Navlink("Sponsors", "/conf/sponsor"),
        Navlink("Quienes somos", "/about-us"),
    ),
    logo = "logo.svg",
    title = "Android Dev Peru"
)

@Composable
fun MainSite(content: @Composable () -> Unit) {
    Navsite(MainSiteNavbar) {
        Div(MainSiteStyle.toAttrs()) {
            content()
        }
    }
}

val MainSiteStyle = CssStyle {
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