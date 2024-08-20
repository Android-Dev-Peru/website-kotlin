package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import kotlinx.browser.document
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.Routes
import web.android.dev.pe.components.utils.MetaTag
import web.android.dev.pe.components.utils.modifyMetaTag
import web.android.dev.pe.components.widgets.Language
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
fun ConferenceSite(lang: Language, content: @Composable () -> Unit) {
    LaunchedEffect(lang) {
        setupTags(lang)
    }

    LocalizedSite(ConferenceNavbar, lang.code) {
        Div(ConferenceSiteStyle.toAttrs()) {
            content()
            MainFooter(extraLinks = listOf(
                Navlink(path = Routes.AboutUs) { ResStrings.conf_navlink_about_us },
                Navlink(path = Routes.Conf.CodeOfConduct) { ResStrings.conf_navlink_code_of_conduct },
            ))
        }
    }
}

fun setupTags(lang: Language) {
    document.title = ResStrings.conf_meta_title
    modifyMetaTag(MetaTag.TITLE, ResStrings.conf_meta_title)
    modifyMetaTag(MetaTag.OG_TITLE, ResStrings.conf_meta_title)
    modifyMetaTag(MetaTag.TWITTER_TITLE, ResStrings.conf_meta_title)

    modifyMetaTag(MetaTag.DESCRIPTION, ResStrings.conf_meta_description)
    modifyMetaTag(MetaTag.OG_DESCRIPTION, ResStrings.conf_meta_description)
    modifyMetaTag(MetaTag.TWITTER_DESCRIPTION, ResStrings.conf_meta_description)

    modifyMetaTag(MetaTag.OG_LOCALE, lang.locale)

    val url = Res.Links.Conf.Index
    modifyMetaTag(MetaTag.OG_URL, url)
    modifyMetaTag(MetaTag.TWITTER_URL, url)

    val thumbnail = "${url}/thumbnail_${lang.code}.webp"
    modifyMetaTag(MetaTag.OG_IMAGE, thumbnail)
    modifyMetaTag(MetaTag.TWITTER_IMAGE, thumbnail)
}

val ConferenceSiteStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }
}
