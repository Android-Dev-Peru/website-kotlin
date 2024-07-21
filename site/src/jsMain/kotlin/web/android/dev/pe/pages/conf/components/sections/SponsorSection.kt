package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection
import web.android.dev.pe.pages.conf.components.layouts.ConferenceSection
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground

@Composable
fun SponsorSection() {
    ConferenceGridSection(
        modifier = Modifier,
        header = {
            Details()
        },
        content = {
            Sponsors()
        }
    )
}


@Composable
private fun Details() {
    H2 { Text("Sé un sponsor") }
    P { Text("Este evento no sería posible sin su ayuda. ¿Te gustaría apoyar a la comunidad y dar a conocer tu empresa a toda nuestra audiencia?") }
    PrimaryButton(
        text = "Más información",
        href = Res.Links.Conf.SponsorBrief,
        modifier = Modifier.margin(topBottom = 16.px)
    )
}

private val SponsorsLogos = listOf("upc_logo.png", "tu_logo_aqui.png")

@Composable
private fun Sponsors() {
    SimpleGrid(
        numColumns = numColumns(3),
        modifier = Modifier
    ) {
        SponsorsLogos.forEach {
            Image(
                src = "images/$it",
                alt = "",
                modifier = Modifier.size(160.px)
            )
        }
    }
}