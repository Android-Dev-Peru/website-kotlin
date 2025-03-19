package web.android.dev.pe.pages.conf.year_2024.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.pages.conf.year_2024.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.year_2024.ConferenceDetails
import web.android.dev.pe.pages.conf.year_2024.components.sections.SpeakersSection

@Page("/conf/2024/speakers")
@Composable
fun SpeakersPage() {
    ConferenceSite(lang = Language.Spanish) {
        SpeakersSection(ConferenceDetails.talks)
    }
}

@Page("/conf/2024/speakers/en")
@Composable
fun SpeakersPage_EN() {
    ConferenceSite(lang = Language.English) {
        SpeakersSection(ConferenceDetails.talks)
    }
}
