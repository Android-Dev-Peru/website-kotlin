package web.android.dev.pe.pages.conf.year_2025.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toModifier
import web.android.dev.pe.pages.conf.year_2025.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.year_2025.ConferenceDetails
import web.android.dev.pe.pages.conf.year_2025.components.sections.AgendaSection
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Page("/conf/agenda")
@Composable
fun AgendaPage() {
    ConferenceSite(lang = Language.Spanish) {
        AgendaSection(ConferenceDetails.agenda, AlternateBackground.toModifier())
    }
}

@Page("/conf/agenda/en")
@Composable
fun AgendaPage_EN() {
    ConferenceSite(lang = Language.English) {
        AgendaSection(ConferenceDetails.agenda, AlternateBackground.toModifier())
    }
}