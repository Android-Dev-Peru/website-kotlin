package web.android.dev.pe.pages.conf.year_2024.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.components.widgets.RectangularPrimaryButtonVariant


@Composable
fun ConferenceHeader(sectionModifier: Modifier = Modifier) {
    Div(ConferenceHeaderStyles2024.container.toAttrs()) {
        HeaderImage()
        HeaderContent()
    }
}

@Composable
private fun HeaderContent() {
    val styles = ConferenceHeaderStyles2024
    Column(Modifier.gap(16.px), horizontalAlignment = Alignment.CenterHorizontally) {
        SpanText(ResStrings.conf_title, ConferenceHeaderStyles2024.title.toModifier())
        PrimaryButton(
            text = ResStrings.conf_events_register.uppercase(),
            href = Res.Links.Conf2024.Register("webhero"),
            modifier = Modifier.margin(topBottom = 16.px).fontWeight(FontWeight.ExtraBold),
            variant = RectangularPrimaryButtonVariant,
        )
        SpanText(ResStrings.conf_header_time, ConferenceHeaderStyles2024.details.toModifier())
        SpanText(ResStrings.conf_header_location, ConferenceHeaderStyles2024.details.toModifier())
        SpanText(
            text = ResStrings.conf_header_caption,
            modifier = ConferenceHeaderStyles2024.caption.toModifier()
        )
    }
}

@Composable
private fun HeaderImage() {
    Image(
        src = "/events/conf2024/android_microfono.webp",
        modifier = ConferenceHeaderStyles2024.image.toModifier()
    )
}

object ConferenceHeaderStyles2024 {
    val container = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.ColumnReverse)
                .justifyContent(JustifyContent.Center)
                .alignItems(AlignItems.Center)
                .padding(2.em)
        }
        Breakpoint.MD {
            Modifier
                .height(90.vh)
                .flexDirection(FlexDirection.Column)
        }
        cssRule(" span") {
            Modifier.fillMaxWidth().textAlign(TextAlign.Center)
        }
    }
    val title = CssStyle {
        base {
            Modifier
                .fontSize(48.px)
                .fontWeight(FontWeight.ExtraBlack)
        }
        Breakpoint.MD {
            Modifier
                .fontSize(60.px)
        }
    }
    val caption = CssStyle {
        base {
            Modifier.fontSize(FontSize.XLarge).margin(topBottom = 20.px)
        }
    }
    val details = CssStyle.base {
        Modifier.fontSize(FontSize.Large)
    }
    val image = CssStyle {
        base {
            Modifier.fillMaxWidth().maxWidth(150.px)
        }
        Breakpoint.MD {
            Modifier.maxWidth(250.px)
        }
    }
}