package web.android.dev.pe.pages.conf.components.widgets

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
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.pages.home.MobileBreakpoint

@Composable
fun ConferenceCard(modifier: Modifier = Modifier) {
    Div(modifier.then(ShinyCardStyles.Container.toModifier()).toAttrs()) {
        H3(ShinyCardStyles.Title.toAttrs()) { Text("ANDROID DEV PERU CONF") }
        P(ShinyCardStyles.Hint.toAttrs()) { Text("Sábado 19 de Octubre") }
        P(ShinyCardStyles.Hint.toAttrs()) { Text("Lima, Peru 🇵🇪") }
    }
}

object ShinyCardStyles {
    val Container = CssStyle {
        base {
            Modifier
                .background(
                    Background.of(
                        image = BackgroundImage.of(url("/images/droid.svg")),
                        repeat = BackgroundRepeat.NoRepeat,
                        position = BackgroundPosition.of(CSSPosition(Edge.Right(57.px), Edge.Bottom((-53).px))),
                        size = BackgroundSize.of(200.px)
                    )
                )
                .boxShadow(0.px, 0.px, 10.px, 0.px, Color.rgb(0xA5C742))
                .borderRadius(10.px)
                .padding(40.px)
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

        cssRule(MobileBreakpoint) {
            Modifier
                .background(
                    Background.of(
                        image = BackgroundImage.of(url("images/droid.svg")),
                        repeat = BackgroundRepeat.NoRepeat,
                        position = BackgroundPosition.of(CSSPosition(Edge.CenterX, Edge.Bottom((-28).px))),
                        size = BackgroundSize.of(100.px)
                    )
                )
                .padding(top = 20.px, bottom = 100.px, leftRight = 20.px)
                .alignItems(AlignItems.Center)
        }
    }
    val Title = CssStyle {
        base {
            Modifier
                .margin(8.px)
                .fontWeight(800)
                .fontSize(60.px)
                .color(Res.Theme.PRIMARY.color)
        }
        cssRule(MobileBreakpoint) {
            Modifier
                .textAlign(TextAlign.Center)
                .fontSize(30.px)
        }
    }
    val Hint = CssStyle {
        base {
            Modifier
                .textTransform(TextTransform.Uppercase)
                .fontSize(20.px)
                .margin(0.px)
                .color(Res.Theme.TEXT.color)
        }
        cssRule(MobileBreakpoint) {
            Modifier
                .fontSize(14.px)
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