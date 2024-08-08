package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.components.widgets.OutlinePrimaryButtonVariant
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun SponsorSection(
    ctaTitle: String,
    ctaPath: String,
    sectionModifier: Modifier = Modifier,
    modifier: Modifier = Modifier,
) {
    ConferenceGridSection(
        sectionModifier = sectionModifier,
        modifier = modifier,
        header = {
            Details(ctaTitle, ctaPath)
        },
        content = {
            Sponsors()
        }
    )
}


@Composable
private fun Details(ctaTitle: String, ctaPath: String) {
    H2 {
        HeadingDecorator()
        Text(ResStrings.conf_sponsor_title)
    }
    P { Text(ResStrings.conf_sponsor_caption) }
    PrimaryButton(
        text = ctaTitle,
        href = ctaPath,
        modifier = Modifier.margin(topBottom = 16.px),
        variant = OutlinePrimaryButtonVariant,
    )
}

private val SponsorsLogos = listOf("sponsor_logo_upc.png")

@Composable
private fun Sponsors() {
    SimpleGrid(
        numColumns = numColumns(3),
        modifier = Modifier
    ) {
        SponsorsLogos.forEach {
            Image(
                src = "/events/conf2024/$it",
                alt = "",
                modifier = Modifier.size(160.px)
            )
        }
    }
}