package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BlurredBackground
import web.android.dev.pe.pages.conf.components.layouts.ConferenceSection
import web.android.dev.pe.pages.conf.components.sections.CallForPapersSection
import web.android.dev.pe.pages.conf.components.sections.LocationSection
import web.android.dev.pe.pages.conf.components.sections.SponsorSection
import web.android.dev.pe.pages.conf.components.widgets.ConferenceCard

@Page("/conf")
@Composable
fun ConferenceLanding() {
    Div(Modifier.fillMaxWidth().toAttrs()) {
        ConferenceHeader()
        LocationSection()
        CallForPapersSection()
        SponsorSection()
    }
}

@Composable
fun ConferenceHeader() {
    ConferenceSection {
        Box(Modifier
            .fillMaxSize()
        ) {
//            BlurredBackground(Modifier.position(Position.Relative).fillMaxSize())
            ConferenceCard(Modifier
                .backgroundColor(rgba(255,255,255,0.9))
                .margin(2.em)
                .align(Alignment.Center)
            )
        }
    }
}