package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Routes
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun EventSection(sectionModifier: Modifier = Modifier) {
    ConferenceGridSection(
        sectionModifier = sectionModifier,
        modifier = Modifier,
        header = {
            Details()
        },
        content = {
            DetailImage()
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
    PrimaryButton(
        text = ResStrings.conf_events_register,
        href = Routes.Conf.Register,
        modifier = Modifier.margin(topBottom = 16.px)
    )
}

@Composable
private fun DetailImage() {
    Image(
        src = "/events/conf2024/adp-stock-photo-1.webp",
        modifier = Modifier.width(100.percent)
    )
}