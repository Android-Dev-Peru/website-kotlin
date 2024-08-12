package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Theme
import web.android.dev.pe.components.CaptionStyle
import web.android.dev.pe.data.CardContent
import web.android.dev.pe.get


@Composable
fun Card(caption: String, content: CardContent, modifier: Modifier = Modifier) {
    Div(CardStyles.Container.toModifier()
        .then(modifier)
        .onClick { window.location.href = content.url }
        .toAttrs()
    ) {
        Div(CardStyles.LeftSection.toAttrs()) {
            SpanText(caption, CaptionStyle)
            H3 { Text(content.title())  }
            P {
                MultiLineText(content.description())
            }
            Spacer()
            Div(CardStyles.Cta.toAttrs()) {
                Link(path = content.url) { Text(content.cta()) }
            }
        }
        Div(CardStyles.RightSection.toAttrs()) {
            Image(
                src = content.image,
                modifier = CardStyles.Icon.toModifier()
            )
        }
    }
}

object CardStyles {
    val Container = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .alignItems(AlignItems.End)
                .height(autoLength)
                .padding(32.px)
                .borderRadius(24.px)
                .border {
                    width(1.px)
                    style(LineStyle.Solid)
                    color(colorMode.get(Theme.border))
                }
                .cursor(Cursor.Pointer)
        }
        hover {
            Modifier
                .boxShadow(0.px, 8.px, 16.px, color = colorMode.get(Theme.shadow))
        }
        cssRule(" h3") {
            Modifier
                .margin(8.px, 0.px)
        }
        cssRule(" a") {
            Modifier
                .border(2.px, LineStyle.Solid, colorMode.get(Theme.onSurface))
                .borderRadius(96.px)
                .color(colorMode.get(Theme.onSurface))
                .textDecorationLine(TextDecorationLine.None)
                .padding(10.px, 15.px)
                .display(DisplayStyle.Inline)
        }
        cssRule(":hover a") {
            Modifier
                .backgroundColor(colorMode.get(Theme.onSurface))
                .border(2.px, LineStyle.Solid, colorMode.get(Theme.surface))
                .color(colorMode.get(Theme.surface))
        }

        Breakpoint.MD {
            Modifier
                .flexDirection(FlexDirection.Row)
                .alignItems(AlignItems.Start)
        }
    }

    val Icon = CssStyle {
        base {
            Modifier
                .maxHeight(60.px)
                .margin(topBottom = 20.px)
                .alignSelf(AlignSelf.Center)
        }

        Breakpoint.MD {
            Modifier
                .maxHeight(200.px)
                .margin(0.px)
        }
    }

    val LeftSection = CssStyle {
        base {
            Modifier
                .flex(1)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .justifyContent(JustifyContent.Center)
                .fillMaxHeight()
                .margin(0.px)
        }
        Breakpoint.MD {
            Modifier.margin(8.px)
        }
    }

    val RightSection = CssStyle {
        base {
            Modifier
                .height(autoLength)
                .display(DisplayStyle.Flex)
                .justifyContent(JustifyContent.Center)
                .alignItems(AlignItems.Center)
                .alignSelf(AlignSelf.SelfEnd)
        }
        Breakpoint.MD {
            Modifier.alignSelf(AlignSelf.Center)
        }
    }

    val Cta = CssStyle.base {
        Modifier
            .display(DisplayStyle.InlineBlock)
            .margin(top = 10.px)
            .height(44.px)
    }

}