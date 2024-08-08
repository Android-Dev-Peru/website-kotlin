package web.android.dev.pe.pages.conf.subpages.sponsorship

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.pages.conf.components.sections.SponsorSection
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection

@Page("/conf/sponsorship")
@Composable
fun ConfSponsorship() {
    ConferenceSite("es") {
        Content()
    }
}

@Page("/conf/sponsorship/en")
@Composable
fun ConfSponsorshipEnglish() {
    ConferenceSite("en") {
        Content()
    }
}

@Composable
private fun Content() {
    Div(ConfSponsorshipStyles.mainContainer.toAttrs()) {
        TwoPaneSection(
            modifier = Modifier.padding(top = 2.em).maxWidth(90.percent),
            distribution = 2 to 1,
            header = { Information() },
            content = { Photos() }
        )
    }
}

@Composable
private fun Information() {
    H2 { Text(ResStrings.conf_sponsorship_title) }
    P { Text(ResStrings.conf_sponsorship_p1) }

    P { Text(ResStrings.conf_sponsorship_p2) }
    Ul {
        Li {
            Text(ResStrings.conf_sponsorship_p2_li1)
            Ul {
                Li { Text(ResStrings.conf_sponsorship_p2_li1_1) }
                Li { Text(ResStrings.conf_sponsorship_p2_li1_2) }
                Li { Text(ResStrings.conf_sponsorship_p2_li1_3) }
                Li { Text(ResStrings.conf_sponsorship_p2_li1_4) }
            }
        }
        Li {
            Text(ResStrings.conf_sponsorship_p2_li2)
            Ul {
                Li { Text(ResStrings.conf_sponsorship_p2_li2_1) }
                Li { Text(ResStrings.conf_sponsorship_p2_li2_2) }
                Li { Text(ResStrings.conf_sponsorship_p2_li2_3) }
            }
        }
    }

    P { Text(ResStrings.conf_sponsorship_p3) }
    Ul {
        Li { Text(ResStrings.conf_sponsorship_p3_li1) }
        Li { Text(ResStrings.conf_sponsorship_p3_li2) }
        Li { Text(ResStrings.conf_sponsorship_p3_li3) }
        Li { Text(ResStrings.conf_sponsorship_p3_li4) }
    }

    P { Text(ResStrings.conf_sponsorship_p4) }
    SponsorshipPlans()

    SponsorSection(
        ctaTitle = ResStrings.conf_sponsor_i_want_to_sponsor,
        ctaPath = Res.Links.Conf.SponsorBrief,
        modifier = Modifier.padding(0.em).margin(top = 2.em)
    )
}

@Composable
private fun Photos() {
    Column(ConfSponsorshipStyles.photosContainer.toModifier()) {
        EventPhoto("adp-event-group-photo-1.webp")
        EventPhoto("adp-event-group-photo-2.webp")
        EventPhoto("adp-event-group-photo-3.webp")
        EventPhoto("adp-event-group-photo-4.webp")
        EventPhoto("adp-event-group-photo-5.webp")
        EventPhoto("adp-event-group-photo-6.webp")
        EventPhoto("adp-event-group-photo-7.webp")
    }
}

@Composable
private fun EventPhoto(name: String) {
    Image(
        src = "/events/conf2024/$name",
        modifier = Modifier.fillMaxWidth().height(autoLength)
    )
}

object ConfSponsorshipStyles {
    val mainContainer = CssStyle {
        base {
            Modifier.padding(1.em).fontSize(18.px).lineHeight(1.5)
        }
        Breakpoint.MD {
            Modifier.padding(leftRight = 2.em)
        }
        cssRule(" h2") {
            Modifier.margin(0.px)
        }
    }
    val photosContainer = CssStyle {
        base {
            Modifier.gap(12.px)
        }
        Breakpoint.MD {
            Modifier.padding(left = 1.em)
        }
    }
}
