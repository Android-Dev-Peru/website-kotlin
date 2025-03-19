package web.android.dev.pe.pages.conf.year_2024.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.year_2024.components.layouts.ConferenceGridSection

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
    H2 {
        HeadingDecorator()
        Text(ResStrings.conf_c4p_title)
    }
    P { Text(ResStrings.conf_c4p_caption) }
    PrimaryButton(
        text = ResStrings.conf_c4p_cta,
        href = Res.Links.Conf2024.C4P,
        modifier = Modifier.margin(top = 16.px)
    )
}

@Composable
private fun SpeakersImage() {
    Image(
        src = "/events/conf2024/c4p-cropped.webp",
        modifier = Modifier.width(100.percent)
    )
}