package web.android.dev.pe.pages.conf.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.components.sections.SpeakersSection

@Page("/conf/speakers")
@Composable
fun SpeakersPage() {
    ConferenceSite(lang = Language.Spanish) {
        SpeakersSection()
    }
}

@Page("/conf/speakers/en")
@Composable
fun SpeakersPage_EN() {
    ConferenceSite(lang = Language.English) {
        SpeakersSection()
    }
}
