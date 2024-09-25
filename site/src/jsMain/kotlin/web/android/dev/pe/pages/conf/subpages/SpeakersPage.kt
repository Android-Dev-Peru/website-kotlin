package web.android.dev.pe.pages.conf.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.ADPConf2024
import web.android.dev.pe.pages.conf.components.sections.SpeakersSection

@Page("/conf/speakers")
@Composable
fun SpeakersPage() {
    ConferenceSite(lang = Language.Spanish) {
        SpeakersSection(ADPConf2024.talks)
    }
}

@Page("/conf/speakers/en")
@Composable
fun SpeakersPage_EN() {
    ConferenceSite(lang = Language.English) {
        SpeakersSection(ADPConf2024.talks)
    }
}
