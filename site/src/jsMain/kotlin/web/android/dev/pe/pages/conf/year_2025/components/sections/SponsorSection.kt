package web.android.dev.pe.pages.conf.year_2025.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.JustifySelf
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import strings.ResStrings
import web.android.dev.pe.Routes
import web.android.dev.pe.Theme
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.components.utils.appendCurrentLanguage
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.components.widgets.OutlinePrimaryButtonVariant
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.get
import web.android.dev.pe.pages.conf.year_2025.components.layouts.ConferenceGridSection
import web.android.dev.pe.pages.conf.year_2025.subpages.sponsorship.SponsorshipPlan


class Sponsor(
    val name: String,
    val url: String,
    val plan: SponsorshipPlan,
    val logo: String,
    val darkLogo: String = logo,
)

@Composable
fun SponsorSection(sponsors: List<Sponsor>, sectionModifier: Modifier = Modifier, modifier: Modifier = Modifier) {
    val isSmallScreen = mutableIsSmallScreen()
    ConferenceGridSection(
        sectionModifier = sectionModifier,
        header = { Details() },
        content = { Sponsors(sponsors) }
    )
}

@Composable
private fun Details() {
    H2 {
        HeadingDecorator()
        Text(ResStrings.conf_2025_sponsor_title)
    }
    P { Text(ResStrings.conf_2025_sponsor_caption) }
    P { Text(ResStrings.conf_2025_sponsor_join) }
    PrimaryButton(
        text = ResStrings.conf_2025_sponsor_im_interested,
        href = Routes.Conf.Year2025.Sponsorship.appendCurrentLanguage(),
        modifier = Modifier.margin(topBottom = 16.px),
        variant = OutlinePrimaryButtonVariant,
    )
}

@Composable
private fun Sponsors(sponsors: List<Sponsor>) {
    val sponsorsByPlan = sponsors.groupBy { it.plan }
    sponsorsByPlan.forEach {
        GroupedSponsors(plan = it.key, sponsors = it.value)
    }
}

@Composable
private fun GroupedSponsors(plan: SponsorshipPlan, sponsors: List<Sponsor>) {
    Div(Modifier.margin(bottom = 2.em).toAttrs()) {
//        HorizontalDivider(Modifier.border { color(plan.borderColor) })
//        H3 { Text("→ ${plan.title}") }
        SimpleGrid(numColumns(base = 2, md = 3)) {
            sponsors.forEach {
                Link(path = it.url, Modifier.justifySelf(JustifySelf.Center)) {
                    Image(
                        src = it.themedLogo(),
                        alt = it.name,
                        modifier = Modifier.size(plan.iconSize.px).objectFit(ObjectFit.Contain)
                    )
                }
            }
        }
    }

}

private val SponsorshipPlan.borderColor
    get() = when(this) {
        SponsorshipPlan.Gold -> Colors.Gold
        SponsorshipPlan.Silver -> Colors.Silver
        SponsorshipPlan.Bronze -> Colors.Chocolate
    }

private val SponsorshipPlan.title: String
    get() = when(this) {
        SponsorshipPlan.Gold -> ResStrings.conf_2025_sponsor_plan_gold
        SponsorshipPlan.Silver -> ResStrings.conf_2025_sponsor_plan_silver
        SponsorshipPlan.Bronze -> ResStrings.conf_2025_sponsor_plan_bronze
    }

private val SponsorshipPlan.iconSize: Int
    get() = when(this) {
        SponsorshipPlan.Gold -> 160
        SponsorshipPlan.Silver -> 120
        SponsorshipPlan.Bronze -> 80
    }

@Composable
private fun Sponsor.themedLogo(): String {
    val colorMode by ColorMode.currentState
    return if(colorMode.isLight) logo else darkLogo
}

object SponsorSectionStyle {
    val card = CssStyle.base {
        Modifier
            .boxShadow(0.px, 4.px, 16.px, color = colorMode.get(Theme.shadow))
            .backgroundColor(colorMode.get(Theme.surface))
            .textAlign(TextAlign.Center)
            .padding(2.em)
    }
}
