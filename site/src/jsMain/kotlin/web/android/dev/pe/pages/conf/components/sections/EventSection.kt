package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun EventSection(sectionModifier: Modifier = Modifier) {
    ConferenceGridSection(
        sectionModifier = sectionModifier,
        modifier = EventSectionStyle.toModifier(),
        header = {
            DetailImage()
        },
        content = {
            Details()
        }
    )
}

@Composable
private fun Details() {
    H2 {
        HeadingDecorator()
        Text(ResStrings.conf_events_title)
    }
    P {
        Text(ResStrings.conf_events_celebrate)
    }
    P {
        Text(ResStrings.conf_events_enjoy)
        SpanText(ResStrings.conf_events_free, Modifier.fontWeight(FontWeight.ExtraBold))
    }
    P {
        Text(ResStrings.conf_events_registration_soon)
    }
    PrimaryButton(
        text = ResStrings.conf_events_register,
        href = "/subscribe",
        modifier = Modifier.margin(top = 16.px, bottom = 2.em)
    )
}

@Composable
private fun DetailImage() {
    Image(
        src = "/events/conf2024/android_celebrate.webp",
        modifier = Modifier.width(100.percent)
    )
}

val EventSectionStyle = CssStyle {
    base {
        Modifier.flexDirection(FlexDirection.ColumnReverse)
    }
    Breakpoint.MD {
        Modifier.flexDirection(FlexDirection.Row)
    }
}