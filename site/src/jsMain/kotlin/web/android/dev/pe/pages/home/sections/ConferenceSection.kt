package web.android.dev.pe.pages.home.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.CSSAnimation
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color.Companion.rgb
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.animation
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.pages.home.layouts.AlternateBackground
import web.android.dev.pe.pages.home.layouts.HomeSection

@Composable
fun ConferenceSection() {
    HomeSection(
        modifier = Modifier.padding(4.em),
        sectionModifier = AlternateBackground,
    ) {
        Div(ShinyCardStyle.toAttrs()) {
            H2 { Text("ANDROID DEV CONF 2024") }
            SpanText("Sábado 19 de Octubre, 2024")
            SpanText("Lima, Peru 🇵🇪")
        }
    }
}

val ShinyCardStyle = CssStyle {
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
            .boxShadow(0.px, 0.px, 10.px, 0.px, rgb(0xA5C742))
            .position(Position.Relative)
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
    cssRule(" h2") {
        Modifier
            .margin(8.px)
            .fontWeight(800)
            .fontSize(60.px)
            .color(rgb(0x38761d))
    }
    cssRule(" h3") {
        Modifier
            .margin(8.px)
    }
    cssRule(" span") {
        Modifier
            .fontSize(20.px)
    }
//    hover {
//        Modifier
//            .animation(CSSAnimation(playState = AnimationPlayState.Paused))
//    }
}
val ShadowPulse = Keyframes {
    0.percent {
        Modifier
            .boxShadow(0.px, 0.px, 10.px, 0.px, rgb(0xA5C742))
    }
    50.percent {
        Modifier
            .boxShadow(0.px, 0.px, 20.px, 0.px, rgb(0xA5C742))
    }
    100.percent {
        Modifier
            .boxShadow(0.px, 0.px, 10.px, 0.px, rgb(0xA5C742))
    }
}
