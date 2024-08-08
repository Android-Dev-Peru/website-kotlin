package web.android.dev.pe.pages.conf.subpages.sponsorship

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res

@Composable
fun SponsorshipPlans() {
    Div(SponsorshipPlansStyle.toAttrs()) {
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_header,
            planA = "Plan A",
            planB = "Plan B",
            planC = "Plan C",
            modifier = Modifier.fontWeight(FontWeight.ExtraBold).backgroundColor(rgb(240,240,240))
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_rate,
            planA = "$700",
            planB = "$400",
            planC = ResStrings.conf_sponsorship_plan_benefit_rate_talk_to_us
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_company_logos,
            planA = "✅",
            planB = "✅",
            planC = "✅"
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_delivery_merch,
            planA = "✅",
            planB = "✅",
            planC = "✅"
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_delivery_brochures,
            planA = "✅",
            planB = "✅",
            planC = "✅"
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_mentions,
            planA = "✅",
            planB = "✅",
            planC = "✅"
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_logo_size,
            planA = "XL",
            planB = "L",
            planC = "S"
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_company_time_slot,
            planA = "10 min",
            planB = "5 min",
            planC = ""
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_banner_at_entrance,
            planA = "✅",
            planB = "✅",
            planC = ""
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_banner_at_auditorium,
            planA = "✅",
            planB = "",
            planC = ""
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_company_speaker,
            planA = "✅ *",
            planB = "",
            planC = ""
        )
    }
    Br()
    SpanText(
        text = ResStrings.conf_sponsorship_plan_disclaimer,
        modifier = Modifier.fontStyle(FontStyle.Italic)
    )
}

@Composable
private fun SponsorshipPlanRow(
    benefit: String,
    planA: String,
    planB: String,
    planC: String,
    modifier: Modifier = Modifier
) {
    SpanText(benefit, Modifier.textAlign(TextAlign.Start).padding(topBottom = 12.px, leftRight = 8.px).then(modifier))
    SpanText(planA, Modifier.alignContent(AlignContent.Center).then(modifier))
    SpanText(planB, Modifier.alignContent(AlignContent.Center).then(modifier))
    SpanText(planC, Modifier.alignContent(AlignContent.Center).then(modifier))
}

val SponsorshipPlansStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                size(auto)
                size(75.px)
                size(75.px)
                size(75.px)
            }
            .borderCollapse(BorderCollapse.Collapse)
            .border(1.px, LineStyle.Solid, Res.Theme.BORDER.color)
            .fontSize(12.px)
    }
    Breakpoint.MD {
        Modifier
            .fontSize(16.px)
            .gridTemplateColumns {
                size(auto)
                size(100.px)
                size(100.px)
                size(100.px)
            }
    }

    cssRule("span") {
        Modifier
            .border(1.px, LineStyle.Solid, Res.Theme.BORDER.color)
            .textAlign(TextAlign.Center)
            .padding(4.px)
    }
}

