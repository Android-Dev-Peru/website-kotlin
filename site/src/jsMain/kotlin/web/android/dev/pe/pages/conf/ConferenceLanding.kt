package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toModifier
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.components.sections.*
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Page("/conf")
@Composable
fun ConferenceLanding() {
    ConferenceSite(lang = Language.Spanish) {
        Content()
    }
}

@Page("/conf/en")
@Composable
fun ConferenceLanding_EN() {
    ConferenceSite(lang = Language.English) {
        Content()
    }
}

@Composable
private fun Content() {
    with(ADPConf2024) {
        ConferenceHeader()
        EventSection(AlternateBackground.toModifier())
        LocationSection()
        AgendaSection(agenda, AlternateBackground.toModifier())
        SpeakersSection(talks)
        SponsorSection(sponsors, AlternateBackground.toModifier())
        VolunteerSection()
    }
}
