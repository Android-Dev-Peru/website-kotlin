package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.data.CardContent


@Composable
fun Card(caption: String, content: CardContent, modifier: Modifier = Modifier) {
    Div(CardStyles.Container.toModifier()
        .then(modifier)
        .onClick { window.location.href = content.url }
        .toAttrs()
    ) {
        Div(CardStyles.LeftSection.toAttrs()) {
            SpanText(caption)
            H3 { Text(content.title)  }
            P { Text(content.description) }
            Div(CardStyles.Cta.toAttrs()) {
                Link(path = content.url) { Text(content.cta) }
            }
        }
        Div(CardStyles.RightSection.toAttrs()) {
            Image(src = "images/${content.image}", alt = content.title)
        }
    }
}

object CardStyles {
    val Container = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Row)
                .alignItems(AlignItems.Center)
                .height(350.px)
                .padding(32.px)
                .borderRadius(24.px)
                .border {
                    width(1.px)
                    style(LineStyle.Solid)
                    color(rgb(218, 220, 224))
                }
                .cursor(Cursor.Pointer)
        }
        hover {
            Modifier
                .boxShadow(0.px, 4.px, 16.px, color = rgba(0, 0, 0, 0.2f))
        }
        cssRule(" h3") {
            Modifier
                .margin(8.px, 0.px)
        }
        cssRule(" a") {
            Modifier
                .border(2.px, LineStyle.Solid, Colors.Black)
                .borderRadius(96.px)
                .color(Colors.Black)
                .textDecorationLine(TextDecorationLine.None)
                .padding(10.px, 15.px)
                .display(DisplayStyle.Inline)
        }
        cssRule(":hover a") {
            Modifier
                .backgroundColor(Colors.Black)
                .color(Colors.White)
        }
        cssRule(" img") {
            Modifier
                .maxHeight(150.px)
                .alignSelf(AlignSelf.Center)
        }
    }
    val LeftSection = CssStyle.base {
        Modifier
            .flex(1)
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .justifyContent(JustifyContent.Center)
            .margin(8.px)
            .fillMaxHeight()
    }

    val RightSection = CssStyle.base {
        Modifier
            .flex(1)
            .height(autoLength)
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .alignItems(AlignItems.Center)
    }

    val Cta = CssStyle.base {
        Modifier
            .display(DisplayStyle.InlineBlock)
            .margin(top = autoLength)
    }

}