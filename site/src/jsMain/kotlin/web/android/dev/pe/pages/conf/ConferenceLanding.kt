package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.pages.conf.components.sections.CallForPapersSection
import web.android.dev.pe.pages.conf.components.sections.ConferenceHeader
import web.android.dev.pe.pages.conf.components.sections.LocationSection
import web.android.dev.pe.pages.conf.components.sections.SponsorSection

@Page("/conf")
@Composable
fun ConferenceLanding() {
    ConferenceSite {
        ConferenceHeader()
        LocationSection()
        CallForPapersSection()
        SponsorSection()
    }
}
