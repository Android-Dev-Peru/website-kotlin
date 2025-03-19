package web.android.dev.pe.pages.conf.year_2024.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Theme
import web.android.dev.pe.get

@Composable
fun ConferenceCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Div(ShinyCardStyles2024.Container.toModifier().then(modifier).toAttrs()) {
        content()
    }
}

object ShinyCardStyles2024 {
    val Container = CssStyle {
        base {
            Modifier
                .background(
                    Background.of(
                        image = BackgroundImage.of(url("/images/droid.svg")),
                        repeat = BackgroundRepeat.NoRepeat,
                        position = BackgroundPosition.of(CSSPosition(Edge.CenterX, Edge.Bottom((-28).px))),
                        size = BackgroundSize.of(100.px)
                    )
                )
                .backgroundColor(colorMode.get(Theme.background))
                .padding(top = 20.px, bottom = 100.px, leftRight = 20.px)
                .alignItems(AlignItems.Center)
                .boxShadow(0.px, 0.px, 10.px, 0.px, Color.rgb(0xA5C742))
                .borderRadius(10.px)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .gap(8.px)
                .justifyContent(JustifyContent.Center)
                .animation(
                    ShadowPulse.toAnimation(duration = 1.s, iterationCount = AnimationIterationCount.Infinite)
                )
        }
        cssRule(" h3") {
            Modifier
                .margin(8.px)
        }

        Breakpoint.MD {
            Modifier
                .background(
                    Background.of(
                        image = BackgroundImage.of(url("/images/droid.svg")),
                        repeat = BackgroundRepeat.NoRepeat,
                        position = BackgroundPosition.of(CSSPosition(Edge.Right(57.px), Edge.Bottom((-53).px))),
                        size = BackgroundSize.of(200.px)
                    )
                )
                .backgroundColor(colorMode.get(Theme.background))
                .padding(2.em)
                .alignItems(AlignItems.Start)
        }
    }
    val Title = CssStyle {
        base {
            Modifier
                .margin(8.px)
                .fontWeight(FontWeight.Bold)
                .fontSize(30.px)
                .textAlign(TextAlign.Center)
                .color(Theme.DARK_GREEN)
        }
        Breakpoint.MD {
            Modifier
                .fontSize(60.px)
                .textAlign(TextAlign.Start)
        }
    }
    val Hint = CssStyle {
        base {
            Modifier
                .textTransform(TextTransform.Uppercase)
                .fontSize(14.px)
                .margin(0.px)
        }
        Breakpoint.MD {
            Modifier.fontSize(20.px)
        }
    }
    val ShadowPulse = Keyframes {
        0.percent {
            Modifier
                .boxShadow(0.px, 0.px, 10.px, 0.px, Color.rgb(0xA5C742))
        }
        50.percent {
            Modifier
                .boxShadow(0.px, 0.px, 20.px, 0.px, Color.rgb(0xA5C742))
        }
        100.percent {
            Modifier
                .boxShadow(0.px, 0.px, 10.px, 0.px, Color.rgb(0xA5C742))
        }
    }

}