package web.android.dev.pe.pages.conf

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BlurredBackground
import web.android.dev.pe.pages.conf.components.widgets.ConferenceCard

@Page("/conf")
@Composable
fun ConferenceLanding() {
    Div(Modifier.fillMaxWidth().toAttrs()) {
        ConferenceHeader()
    }
}

@Composable
fun ConferenceHeader() {
    Section(Modifier
        .height(80.vh)
        .overflow { y(Overflow.Auto) }
        .minHeight(600.px)
        .toAttrs()
    ) {
        Box(Modifier
            .fillMaxSize()
            .backgroundColor(Res.Theme.BLACK.color)
        ) {
            BlurredBackground(Modifier.position(Position.Relative).fillMaxSize())
            ConferenceCard(Modifier
                .backgroundColor(rgba(255,255,255,0.9))
                .margin(2.em)
                .align(Alignment.Center)
            )
        }
    }
}
