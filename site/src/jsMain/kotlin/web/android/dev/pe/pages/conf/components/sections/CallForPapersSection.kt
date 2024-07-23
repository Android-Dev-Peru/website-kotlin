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
import web.android.dev.pe.components.widgets.BlobImage
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun CallForPapersSection(sectionModifier: Modifier = Modifier) {
    val isSmallScreen = mutableIsSmallScreen()
    ConferenceGridSection(
        sectionModifier = sectionModifier,
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
    H2 { Text("Call for Speakers") }
    P { Text("Buscamos charlas sobre desarrollo Android, Kotlin, multiplataforma, Gradle, CI/CD, IA/ML, Firebase y más. ¡No dudes en enviarnos tu propuesta!  🎤") }
    PrimaryButton(
        text = "Enviar charla",
        href = Res.Links.Conf.C4P,
        modifier = Modifier.margin(top = 16.px)
    )
}

@Composable
private fun SpeakersImage() {
    BlobImage(
        src = "images/c4p.webp",
        blobSrc = "shapes/blob2.svg",
        modifier = Modifier.width(100.percent)
    )
}