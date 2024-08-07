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
import web.android.dev.pe.components.widgets.LanguageSelectorOptions
import web.android.dev.pe.components.widgets.navsite.Navbar
import web.android.dev.pe.components.widgets.navsite.NavbarLogo
import web.android.dev.pe.components.widgets.navsite.Navlink
import web.android.dev.pe.components.widgets.navsite.Navsite
import web.android.dev.pe.pages.home.components.sections.MainFooter

val MainSiteNavbar = Navbar(
    primaryLink = Navlink(path ="/subscribe") { "Suscríbete" },
    secondaryLinks = listOf(
        Navlink(path ="/") { "Inicio" },
        Navlink(path ="/about-us") { "Quienes somos" },
        Navlink(path ="/resources") { "Recursos" },
        Navlink(path = "/conf") { "Conferencia" },
    ),
    languageSelector = LanguageSelectorOptions.None, // page not localized yet
    logo = NavbarLogo(
        src = "/logo.svg",
        title = { "Android Dev Peru" },
        path = "/",
    ),
)

@Composable
fun MainSite(navbar: Navbar = MainSiteNavbar, content: @Composable () -> Unit) {
    Navsite(navbar) {
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