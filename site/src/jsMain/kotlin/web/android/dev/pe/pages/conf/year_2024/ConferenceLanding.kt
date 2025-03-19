package web.android.dev.pe.pages.conf.year_2024

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toModifier
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.year_2024.components.sections.*
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Page("/conf/2024")
@Composable
fun ConferenceLanding() {
    ConferenceSite(lang = Language.Spanish) {
        Content()
    }
}

@Page("/conf/2024/en")
@Composable
fun ConferenceLanding_EN() {
    ConferenceSite(lang = Language.English) {
        Content()
    }
}

@Composable
private fun Content() {
    with(ConferenceDetails) {
        ConferenceHeader()
        EventSection(AlternateBackground.toModifier())
        LocationSection()
        AgendaSection(agenda, AlternateBackground.toModifier())
        SpeakersSection(talks)
        SponsorSection(sponsors, AlternateBackground.toModifier())
        VolunteerSection()
    }
}
