package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Routes
import web.android.dev.pe.components.widgets.LanguageSelectorOptions
import web.android.dev.pe.components.widgets.navsite.LocalizedSite
import web.android.dev.pe.components.widgets.navsite.Navbar
import web.android.dev.pe.components.widgets.navsite.NavbarLogo
import web.android.dev.pe.components.widgets.navsite.Navlink
import web.android.dev.pe.pages.home.components.sections.MainFooter

val MainSiteNavbar = Navbar(
    primaryLink = Navlink(path = Routes.Subscribe) { ResStrings.site_navlink_subscribe },
    secondaryLinks = listOf(
        Navlink(path = Routes.AboutUs) { ResStrings.site_navlink_about_us },
        Navlink(path = Routes.Resources) { ResStrings.site_navlink_resources },
        Navlink(path = Routes.Conf.Index) { ResStrings.site_navlink_conference },
    ),
    languageSelector = LanguageSelectorOptions.All,
    logo = NavbarLogo(
        src = "/logo.svg",
        title = { "Android Dev Peru" },
        path = Routes.Home,
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
    .textTransform(TextTransform.Uppercase)