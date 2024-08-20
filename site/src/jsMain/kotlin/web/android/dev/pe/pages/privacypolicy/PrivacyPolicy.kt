package web.android.dev.pe.pages.privacypolicy

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.utils.CurvyUnderline
import web.android.dev.pe.components.widgets.CommunityEmailLink
import web.android.dev.pe.components.widgets.DecoratedHeading
import web.android.dev.pe.components.widgets.Language

private object SectionIds {
    const val website = "website"
    const val atteendes = "attendees"
    const val speakers = "speakers"
    const val sponsors = "sponsors"
    const val complaints = "complaints"
    const val yourData = "your-data"
}

@Page("/privacy-policy")
@Composable
fun PrivacyPolicy() {
    MainSite(lang = Language.Spanish) { Content() }
}

@Page("/privacy-policy/en")
@Composable
fun PrivacyPolicy_EN() {
    MainSite(lang = Language.English) { Content() }
}

@Composable
private fun Content() {
    Div(PrivacyPolicyContainer.toAttrs()) {
        Intro()
        WebsiteVisitors()
        Attendees()
        Speakers()
        Sponsors()
        YourRights()
        Complaints()
        AccessYourData()
    }
}

@Composable
private fun Intro() {
    H1 { SpanText(ResStrings.privacy_policy, CurvyUnderline.toModifier()) }
    P { Text(ResStrings.privacy_policy_p1) }
    P { Text(ResStrings.privacy_policy_p2) }
    Ul {
        Li { Link("#${SectionIds.website}") { Text(ResStrings.privacy_policy_website) } }
        Li { Link("#${SectionIds.atteendes}") { Text(ResStrings.privacy_policy_attendees) } }
        Li { Link("#${SectionIds.speakers}") { Text(ResStrings.privacy_policy_speakers) } }
        Li { Link("#${SectionIds.sponsors}") { Text(ResStrings.privacy_policy_sponsors) } }
    }
}

@Composable
private fun WebsiteVisitors() {
    DecoratedHeading(ResStrings.privacy_policy_website, href = SectionIds.website)
    P { Text(ResStrings.privacy_policy_website_p1) }
}

@Composable
private fun Attendees() {
    DecoratedHeading(ResStrings.privacy_policy_attendees, href = SectionIds.atteendes)
    P { Text(ResStrings.privacy_policy_attendees_p1) }
    P { Text(ResStrings.privacy_policy_attendees_p2) }
    P { Text(ResStrings.privacy_policy_attendees_p3) }
    P { Text(ResStrings.privacy_policy_attendees_p4) }
    P { Text(ResStrings.privacy_policy_attendees_p5) }
    P {
        Text(ResStrings.privacy_policy_attendees_p6_pt1)
        CommunityEmailLink()
        Text(ResStrings.privacy_policy_attendees_p6_pt2)
    }
}

@Composable
private fun Speakers() {
    DecoratedHeading(ResStrings.privacy_policy_speakers, href = SectionIds.speakers)
    P { Text(ResStrings.privacy_policy_speakers_p1) }
    P { Text(ResStrings.privacy_policy_speakers_p2) }
    P { Text(ResStrings.privacy_policy_speakers_p3) }
    P { Text(ResStrings.privacy_policy_speakers_p4) }
    P {
        Text(ResStrings.privacy_policy_speakers_p5_pt1)
        Link(Res.Links.YouTube) { Text(ResStrings.privacy_policy_speakers_p5_pt2) }
        Text(ResStrings.privacy_policy_speakers_p5_pt3)
    }
    P { Text(ResStrings.privacy_policy_speakers_p6) }
}

@Composable
private fun Sponsors() {
    DecoratedHeading(ResStrings.privacy_policy_sponsors, href = SectionIds.sponsors)
    P { Text(ResStrings.privacy_policy_sponsors_p1) }
    P { Text(ResStrings.privacy_policy_sponsors_p2) }
    P {
        Text(ResStrings.privacy_policy_sponsors_p3_pt1)
        Link("#attendees") { Text(ResStrings.privacy_policy_attendees) }
        Text(ResStrings.privacy_policy_sponsors_p3_pt2)
    }
    P {
        Text(ResStrings.privacy_policy_sponsors_p4_pt1)
        Link("#your-data") { Text(ResStrings.privacy_policy_rights) }
        Text(ResStrings.privacy_policy_sponsors_p4_pt2)
    }
}


@Composable
private fun YourRights() {
    H1 { SpanText(ResStrings.privacy_policy_rights, CurvyUnderline.toModifier()) }
}

@Composable
private fun Complaints() {
    DecoratedHeading(ResStrings.privacy_policy_complaints, href = SectionIds.complaints)
    P { Text(ResStrings.privacy_policy_complaints_p1) }
}

@Composable
private fun AccessYourData() {
    DecoratedHeading(ResStrings.privacy_policy_access_your_data, href = SectionIds.yourData)
    P { Text(ResStrings.privacy_policy_access_your_data_p1) }
    P { Text(ResStrings.privacy_policy_access_your_data_p2) }
    P { Text(ResStrings.privacy_policy_access_your_data_p3) }
    P { Text(ResStrings.privacy_policy_access_your_data_p4) }
}

val PrivacyPolicyContainer = CssStyle {
    base {
        Modifier.padding(2.em).fontSize(18.px).lineHeight(1.5)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 8.em, topBottom = 2.em).fontSize(20.px)
    }
    cssRule(" h2") {
        Modifier.margin(top = 2.em)
    }
}