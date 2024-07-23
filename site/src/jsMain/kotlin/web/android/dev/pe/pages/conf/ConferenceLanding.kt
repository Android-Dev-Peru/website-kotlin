package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.pages.conf.components.sections.*
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Page("/conf")
@Composable
fun ConferenceLanding() {
    ConferenceSite {
        ConferenceHeader()
        EventSection(AlternateBackground)
        LocationSection()
        CallForPapersSection(AlternateBackground)
        SponsorSection()
    }
}
