package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.components.widgets.MultiLineText
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection
import web.android.dev.pe.pages.conf.components.layouts.ConferenceSection
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Composable
fun CallForPapersSection() {
    val isSmallScreen = mutableIsSmallScreen()
    ConferenceGridSection(
        sectionModifier = AlternateBackground,
        header = {
            if (isSmallScreen) Details() else SpeakersImage()
        },
        content = {
            if (isSmallScreen) SpeakersImage() else Details()
        }
    )
}

@Composable
private fun Details() {
    H2 { Text("Call for Papers") }
    P { Text("Participa en el evento como ponente 🎤") }
    PrimaryButton(
        text = "Enviar charla",
        href = Res.Links.Conf.C4P,
        modifier = Modifier.margin(top = 16.px)
    )
}

@Composable
private fun SpeakersImage() {
    Image(
        src = "images/c4p.webp",
        alt = "",
        modifier = Modifier
            .width(100.percent)
            .styleModifier {
                property("-webkit-mask-image", "url(blob2.svg)")
                property("-webkit-mask-repeat", "no-repeat")
                property("mask-image", "url(shapes/blob2.svg)")
                property("mask-repeat", "no-repeat")
            }
    )
}