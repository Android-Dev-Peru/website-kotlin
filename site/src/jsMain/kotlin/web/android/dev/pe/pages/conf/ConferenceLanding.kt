package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.style.toModifier
import web.android.dev.pe.components.ConferenceSite
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
fun ConferenceLanding_EN() {
    ConferenceSite(lang = "en") {
        Content()
    }
}

@Composable
private fun Content() {
    ConferenceHeader()
    EventSection(AlternateBackground.toModifier())
    LocationSection()
    CallForPapersSection(AlternateBackground.toModifier())
    SponsorSection()
}
