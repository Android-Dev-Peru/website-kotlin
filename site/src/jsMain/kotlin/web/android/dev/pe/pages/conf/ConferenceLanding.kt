package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.rgba
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.pages.conf.components.layouts.ConferenceSection
import web.android.dev.pe.pages.conf.components.sections.CallForPapersSection
import web.android.dev.pe.pages.conf.components.sections.LocationSection
import web.android.dev.pe.pages.conf.components.sections.SponsorSection
import web.android.dev.pe.pages.conf.components.widgets.ConferenceCard
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

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

@Composable
fun ConferenceHeader() {
    ConferenceSection(sectionModifier = AlternateBackground) {
        Box(Modifier
            .fillMaxSize()
        ) {
            ConferenceCard(Modifier
                .backgroundColor(rgba(255,255,255,0.9))
                .margin(2.em)
                .align(Alignment.Center)
            )
        }
    }
}