package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import strings.ResStrings
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.utils.appendCurrentLanguage
import web.android.dev.pe.pages.conf.components.sections.*
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Page("/conf")
@Composable
fun ConferenceLanding() {
    ConferenceSite(lang = "es") {
        Content()
    }
}

@Page("/conf/en")
@Composable
fun ConferenceLandingEnglish() {
    ConferenceSite(lang = "en") {
        Content()
    }
}

@Composable
private fun Content() {
    ConferenceHeader()
    EventSection(AlternateBackground)
    LocationSection()
    CallForPapersSection(AlternateBackground)
    SponsorSection(
        ctaTitle = ResStrings.conf_sponsor_im_interested,
        ctaPath = "/conf/sponsorship".appendCurrentLanguage(),
    )
}
