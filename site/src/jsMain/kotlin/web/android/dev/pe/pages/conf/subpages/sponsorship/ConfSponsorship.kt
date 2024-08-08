package web.android.dev.pe.pages.conf.subpages.sponsorship

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import strings.ResStrings
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.widgets.CommunityEmailLink
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection
import web.android.dev.pe.Res

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
    InterestedInParticipatingSection()
    WhatWeOfferSection()
    ContactUsSection()
}

@Composable
private fun InterestedInParticipatingSection() {
    H2 {
        HeadingDecorator()
        SpanText(ResStrings.conf_sponsorship_title)
    }
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
    P {
        Text(ResStrings.conf_sponsorship_p2_more_about_us_p1)
        Link(path = "/about-us") {
            Text(ResStrings.conf_sponsorship_p2_more_about_us_p2)
        }
    }
}

@Composable
private fun WhatWeOfferSection() {
    H2 {
        HeadingDecorator()
        SpanText(ResStrings.conf_sponsorship_what_we_offer)
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
}

@Composable
private fun ContactUsSection() {
    H2 {
        HeadingDecorator()
        Text(ResStrings.conf_sponsor_i_want_to_sponsor)
    }
    P { Text(ResStrings.conf_sponsor_caption) }
    P { Text(ResStrings.conf_sponsor_i_want_to_sponsor_instructions) }

    Div(ConfSponsorshipStyles.ContactOptionsContainer.toAttrs()) {
        ContactUsOption(icon = "envelope") {
            Text(ResStrings.conf_sponsor_i_want_to_sponsor_email_us_pt1)
            CommunityEmailLink(Modifier.color(Res.Theme.PRIMARY.color))
            Text(ResStrings.conf_sponsor_i_want_to_sponsor_email_us_pt2)

        }
        ContactUsOption(icon = "wpforms", iconCategory = IconCategory.BRAND) {
            Link(Res.Links.Conf.SponsorBrief) {
                Text(ResStrings.conf_sponsor_i_want_to_sponsor_fill_form_pt1)
            }
            Text(ResStrings.conf_sponsor_i_want_to_sponsor_fill_form_pt2)
        }
        ContactUsOption(icon = "calendar") {
            Link(Res.Links.Conf.ScheduleMeeting) {
                Text(ResStrings.conf_sponsor_i_want_to_sponsor_schedule_meeting_pt1)
            }
            Text(ResStrings.conf_sponsor_i_want_to_sponsor_schedule_meeting_pt2)
        }
    }
}

@Composable
private fun ContactUsOption(
    icon: String,
    iconCategory: IconCategory = IconCategory.REGULAR,
    content: @Composable () -> Unit
) {
    P(ConfSponsorshipStyles.ContactOption.toAttrs()) {
        FaIcon(icon, modifier = Modifier, style = iconCategory, size = IconSize.LG)
        Br()
        Br()
        content()
    }
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
        cssRule(" h2") {
            Modifier.margin(0.px)
        }
        cssRule(" a") {
            Modifier.color(Res.Theme.PRIMARY.color)
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
    val ContactOptionsContainer = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .gap(1.em)
                .margin(bottom = 1.em)
        }
        Breakpoint.MD {
            Modifier
                .flexDirection(FlexDirection.Row)
                .gap(2.em)
                .margin(bottom = 2.em)
        }
    }
    val ContactOption = CssStyle.base {
        Modifier
            .boxShadow(0.px, 4.px, 16.px, color = rgba(0, 0, 0, 0.2f))
            .textAlign(TextAlign.Center)
            .padding(1.em)
            .flex(1)
    }
}
