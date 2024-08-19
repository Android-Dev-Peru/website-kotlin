package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.components.utils.appendCurrentLanguage
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.components.widgets.OutlinePrimaryButtonVariant
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection
import web.android.dev.pe.pages.conf.subpages.sponsorship.SponsorshipPlan


private class Sponsor(
    val name: String,
    val url: String,
    val plan: SponsorshipPlan,
    val logo: String,
    val darkLogo: String = logo,
)

private val Sponsors = listOf(
    Sponsor(
        name = "UPC",
        url = "https://www.upc.edu.pe/",
        plan = SponsorshipPlan.Gold,
        logo = "sponsor_logo_upc.png"
    ),
    Sponsor(
        name = "HaystackNews",
        url = "https://www.haystack.tv/",
        plan = SponsorshipPlan.Gold,
        logo = "sponsor_logo_haystack_light.svg",
        darkLogo = "sponsor_logo_haystack_dark.svg"
    ),
    Sponsor(
        name = "NTT Data",
        plan = SponsorshipPlan.Gold,
        url = "https://pe.nttdata.com/",
        logo = "sponsor_logo_ntt.svg",
    ),
)

@Composable
fun SponsorSection(sectionModifier: Modifier = Modifier, modifier: Modifier = Modifier) {
    ConferenceGridSection(
        sectionModifier = sectionModifier,
        modifier = modifier,
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
    H2 {
        HeadingDecorator()
        Text(ResStrings.conf_sponsor_title)
    }
    P { Text(ResStrings.conf_sponsor_caption) }
    PrimaryButton(
        text = ResStrings.conf_sponsor_im_interested,
        href = "/conf/sponsorship".appendCurrentLanguage(),
        modifier = Modifier.margin(topBottom = 16.px),
        variant = OutlinePrimaryButtonVariant,
    )
}

@Composable
private fun Sponsors() {
    val colorMode by ColorMode.currentState
    SimpleGrid(
        numColumns = numColumns(base = 2, md = 3),
        modifier = Modifier
    ) {
        Sponsors.forEach {
            Link(path = it.url) {
                Image(
                    src = "/events/conf2024/${if(colorMode.isLight) it.logo else it.darkLogo}",
                    alt = it.name,
                    modifier = Modifier.size(160.px)
                )
            }
        }
    }
}