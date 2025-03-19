package web.android.dev.pe.pages.conf.year_2024.subpages.sponsorship

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.BorderCollapse
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Theme
import web.android.dev.pe.get

enum class SponsorshipPlan { Gold, Silver, Bronze }

@Composable
fun SponsorshipPlans() {
    val colorMode by ColorMode.currentState
    Div(SponsorshipPlansStyle2024.toAttrs()) {
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_header,
            planA = ResStrings.conf_sponsorship_plan_A,
            planB = ResStrings.conf_sponsorship_plan_B,
            planC = ResStrings.conf_sponsorship_plan_C,
            modifier = Modifier.fontWeight(FontWeight.ExtraBold).backgroundColor(colorMode.get(Theme.tableHeader))
        )
        SponsorshipPlanRow(
            benefit = ResStrings.conf_sponsorship_plan_benefit_mentions,
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
            benefit = ResStrings.conf_sponsorship_plan_benefit_company_logos,
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
            benefit = ResStrings.conf_sponsorship_plan_benefit_logo_physical_merch,
            planA = "✅",
            planB = "✅",
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
            benefit = ResStrings.conf_sponsorship_plan_benefit_attendance_list,
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
    Div(Modifier.height(1.em).toAttrs())
    SpanText(
        text = ResStrings.conf_sponsorship_plan_benefit_company_speaker_disclaimer,
        modifier = Modifier.fontStyle(FontStyle.Italic)
    )
    Div(Modifier.height(2.em).toAttrs())
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

val SponsorshipPlansStyle2024 = CssStyle {
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
            .border(1.px, LineStyle.Solid, colorMode.get(Theme.border))
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
            .border(1.px, LineStyle.Solid, colorMode.get(Theme.border))
            .textAlign(TextAlign.Center)
            .padding(4.px)
    }
}

