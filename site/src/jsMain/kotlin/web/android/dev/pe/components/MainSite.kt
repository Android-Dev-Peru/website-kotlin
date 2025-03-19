package web.android.dev.pe.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.textTransform
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import kotlinx.browser.document
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.Routes
import web.android.dev.pe.components.utils.MetaTag
import web.android.dev.pe.components.utils.modifyMetaTag
import web.android.dev.pe.components.widgets.Language
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
        Navlink(path = Routes.Articles) { ResStrings.site_navlink_articles },
        Navlink(path = Routes.Conf.Year2025.Index) { ResStrings.site_navlink_conference },
    ),
    languageSelector = LanguageSelectorOptions.All,
    logo = NavbarLogo(
        src = "/logo.svg",
        title = { "Android Dev Peru" },
        path = Routes.Home,
    ),
)

@Composable
fun MainSite(lang: Language, navbar: Navbar = MainSiteNavbar, content: @Composable () -> Unit) {
    LaunchedEffect(lang) {
        setupTags(lang)
    }

    LocalizedSite(navbar, lang.code) {
        Div(MainSiteStyle.toAttrs()) {
            content()
            MainFooter(extraLinks = listOf(
                Navlink(path = Routes.AboutUs) { ResStrings.site_navlink_about_us },
                Navlink(path = Routes.PrivacyPolicy) { ResStrings.privacy_policy },
            ))
        }
    }
}

private fun setupTags(lang: Language) {
    document.title = ResStrings.site_metatag_title
    modifyMetaTag(MetaTag.TITLE, ResStrings.site_metatag_title)
    modifyMetaTag(MetaTag.OG_TITLE, ResStrings.site_metatag_title)
    modifyMetaTag(MetaTag.TWITTER_TITLE, ResStrings.site_metatag_title)

    modifyMetaTag(MetaTag.DESCRIPTION, ResStrings.site_metatag_description)
    modifyMetaTag(MetaTag.OG_DESCRIPTION, ResStrings.site_metatag_description)
    modifyMetaTag(MetaTag.TWITTER_DESCRIPTION, ResStrings.site_metatag_description)

    modifyMetaTag(MetaTag.OG_LOCALE, lang.locale)

    val thumbnail = "${Res.Links.Index}/thumbnail_${lang.code}.webp"
    modifyMetaTag(MetaTag.OG_IMAGE, thumbnail)
    modifyMetaTag(MetaTag.TWITTER_IMAGE, thumbnail)
}

val MainSiteStyle = CssStyle {
    base {
        Modifier.fillMaxWidth()
    }
}

val CaptionStyle = Modifier
    .fontSize(14.px)
    .textTransform(TextTransform.Uppercase)