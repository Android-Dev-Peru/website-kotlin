package web.android.dev.pe.pages.conf.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
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
import web.android.dev.pe.Res
import web.android.dev.pe.Theme
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.utils.CurvyUnderline
import web.android.dev.pe.components.widgets.CommunityEmailLink
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.get

@Page("/conf/coc")
@Composable
fun ConfCodeOfConduct() {
    ConferenceSite(lang = Language.Spanish) {
        Div(ConfCodeOfConductStyles.MainContainer.toAttrs()) {
            Content()
        }
    }
}

@Page("/conf/coc/en")
@Composable
fun ConferenceCodeOfConduct_EN() {
    ConferenceSite(lang = Language.English) {
        Div(ConfCodeOfConductStyles.MainContainer.toAttrs()) {
            Content()
        }
    }
}

@Composable
private fun Content() {
    Intro()
    PurposeSection()
    ReportSection()
    ComplianceSection()
    HarassmentSection()
    DiscriminationSection()
    NeedHelpSection()
}

@Composable
private fun Intro() {
    H1 { SpanText(ResStrings.conf_coc_intro_title, CurvyUnderline.toModifier()) }
    P { Text(ResStrings.conf_coc_intro_p1) }
    P { Text(ResStrings.conf_coc_intro_p2) }
}

@Composable
private fun PurposeSection() {
    H2 { Text(ResStrings.conf_coc_purpose_title) }
    P { Text(ResStrings.conf_coc_purpose_p1) }
    P { Text(ResStrings.conf_coc_purpose_p2) }
    P { Text(ResStrings.conf_coc_purpose_p3) }
}

@Composable
private fun ReportSection() {
    val containerStyle = ConfCodeOfConductStyles.ReportCardContainer
    val cardStyle = ConfCodeOfConductStyles.ReportCard

    H2 { Text(ResStrings.conf_coc_report_title) }
    P { Text(ResStrings.conf_coc_report_p1) }
    Br()

    Div(containerStyle.toAttrs()) {
        Div(cardStyle.toAttrs()) { Text(ResStrings.conf_coc_report_card_1) }
        Div(cardStyle.toAttrs()) { Text(ResStrings.conf_coc_report_card_2) }
        Div(cardStyle.toAttrs()) {
            Text(ResStrings.conf_coc_report_card_3)
            Br()
            CommunityEmailLink()
        }
    }
}

@Composable
private fun ComplianceSection() {
    H2 { Text(ResStrings.conf_coc_compliance_title) }
    P { Text(ResStrings.conf_coc_compliance_p1) }
    P { Text(ResStrings.conf_coc_compliance_p2) }
    P { Text(ResStrings.conf_coc_compliance_p3) }
}

@Composable
private fun HarassmentSection() {
    H2 { Text(ResStrings.conf_coc_harassment_title) }
    Ul {
        Li { Text(ResStrings.conf_coc_harassment_p1) }
        Li { Text(ResStrings.conf_coc_harassment_p2) }
        Li { Text(ResStrings.conf_coc_harassment_p3) }
        Li { Text(ResStrings.conf_coc_harassment_p4) }
        Li { Text(ResStrings.conf_coc_harassment_p5) }
        Li { Text(ResStrings.conf_coc_harassment_p6) }
        Li { Text(ResStrings.conf_coc_harassment_p7) }
        Li { Text(ResStrings.conf_coc_harassment_p8) }
    }
}

@Composable
private fun DiscriminationSection() {
    H2 { Text(ResStrings.conf_coc_discrimination_title) }
    P { Text(ResStrings.conf_coc_discrimination_p1) }
}

@Composable
private fun NeedHelpSection() {
    H2 { SpanText(ResStrings.conf_coc_need_help_title, CurvyUnderline.toModifier()) }
    P { Text(ResStrings.conf_coc_need_help_p1) }
    Ul {
        Li {
            Text(ResStrings.conf_coc_need_help_p2)
            Link(path = Res.Links.Twitter) {
                Text("@${Res.Links.Twitter.substringAfterLast("/")}")
            }
        }
        Li {
            Text(ResStrings.conf_coc_need_help_p3)
            CommunityEmailLink()
        }
    }
}

object ConfCodeOfConductStyles {

    val MainContainer = CssStyle {
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
    val ReportCardContainer = CssStyle {
        base {
            Modifier.display(DisplayStyle.Flex).flexDirection(FlexDirection.Column).gap(1.em)
        }
        Breakpoint.MD {
            Modifier.flexDirection(FlexDirection.Row).gap(2.em)
        }
    }
    val ReportCard = CssStyle.base {
        Modifier
            .boxShadow(0.px, 4.px, 16.px, color = colorMode.get(Theme.shadow))
            .backgroundColor(colorMode.get(Theme.surface))
            .textAlign(TextAlign.Center)
            .padding(2.em)
    }
}