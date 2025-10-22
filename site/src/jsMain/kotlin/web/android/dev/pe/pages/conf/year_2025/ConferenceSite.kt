package web.android.dev.pe.pages.conf.year_2025

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
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
    primaryLink = Navlink(path = Res.Links.Conf2025.Register("webnavbar")) { ResStrings.conf_navlink_register },
    secondaryLinks = listOf(
        Navlink(path = Routes.Conf.Year2025.Speakers) { ResStrings.conf_2025_navlink_speakers },
        Navlink(path = Routes.Conf.Year2025.Volunteers) { ResStrings.conf_2025_navlink_volunteer },
        Navlink(path = Routes.AboutUs) { ResStrings.site_navlink_about_us },
    ),
    languageSelector = LanguageSelectorOptions.All,
    logo = NavbarLogo(
        src = "/logo_roboto_peruvian.png",
        title = { ResStrings.conf_title },
        path = Routes.Conf.Year2025.Index,
    ),

)

@Composable
fun ConferenceSite(lang: Language, content: @Composable () -> Unit) {
    LaunchedEffect(lang) {
        setupTags(lang)
    }

    LocalizedSite(ConferenceNavbar, lang.code) {
        Div(Modifier.fillMaxWidth().toAttrs()) {
            content()
            MainFooter(extraLinks = listOf(
                Navlink(path = Routes.AboutUs) { ResStrings.conf_navlink_about_us },
                Navlink(path = Routes.Conf.Year2025.CodeOfConduct) { ResStrings.conf_navlink_code_of_conduct },
            ))
        }
    }
}

private fun setupTags(lang: Language) {
    document.title = ResStrings.conf_2025_meta_title
    modifyMetaTag(MetaTag.TITLE, ResStrings.conf_2025_meta_title)
    modifyMetaTag(MetaTag.OG_TITLE, ResStrings.conf_2025_meta_title)
    modifyMetaTag(MetaTag.TWITTER_TITLE, ResStrings.conf_2025_meta_title)

    modifyMetaTag(MetaTag.DESCRIPTION, ResStrings.conf_2025_meta_description)
    modifyMetaTag(MetaTag.OG_DESCRIPTION, ResStrings.conf_2025_meta_description)
    modifyMetaTag(MetaTag.TWITTER_DESCRIPTION, ResStrings.conf_2025_meta_description)

    modifyMetaTag(MetaTag.OG_LOCALE, lang.locale)

    val url = Res.Links.Conf2025.Index
    modifyMetaTag(MetaTag.OG_URL, url)
    modifyMetaTag(MetaTag.TWITTER_URL, url)

    val thumbnail = "${Res.Links.Index}/events/conf2025/conf_thumbnail_${lang.code}.webp"
    modifyMetaTag(MetaTag.OG_IMAGE, thumbnail)
    modifyMetaTag(MetaTag.TWITTER_IMAGE, thumbnail)
}
