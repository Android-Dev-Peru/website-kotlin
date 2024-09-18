package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.foundation.layout.Column
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


@Composable
fun ConferenceHeader(sectionModifier: Modifier = Modifier) {
    Div(ConferenceHeaderStyles.container.toAttrs()) {
        HeaderImage()
        HeaderContent()
    }
}

@Composable
private fun HeaderContent() {
    val styles = ConferenceHeaderStyles
    Column(Modifier.gap(16.px)) {
        SpanText(ResStrings.conf_title, styles.title.toModifier())
        SpanText(ResStrings.conf_header_time, styles.details.toModifier())
        SpanText(ResStrings.conf_header_location, styles.details.toModifier())
        SpanText(
            text = ResStrings.conf_header_caption,
            modifier = styles.caption.toModifier()
        )
    }
}

@Composable
private fun HeaderImage() {
    Image(
        src = "/events/conf2024/android_peruvian_red.webp",
        modifier = ConferenceHeaderStyles.image.toModifier()
    )
}

object ConferenceHeaderStyles {
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
                .fontSize(60.px)
                .fontWeight(FontWeight.ExtraBlack)
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
            Modifier.maxWidth(300.px)
        }
    }
}