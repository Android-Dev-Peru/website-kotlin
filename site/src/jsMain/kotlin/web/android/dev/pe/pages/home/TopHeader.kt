package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.before
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H2
import web.android.dev.pe.Res
import web.android.dev.pe.data.Social
import web.android.dev.pe.data.Socials

@Composable
fun TopHeader() {
    val socials = Socials.entries
    Div(TopHeaderStyle.toModifier().toAttrs()) {
        Image(src = "logo.svg", alt = "Logo de Android Dev Peru")
        H1 { SpanText("Android Dev Peru") }
        H2 { SpanText("Comunidad de desarrolladores Android en Peru y LATAM") }
        Div(SocialMediaRowStyle.toModifier().toAttrs()) {
            socials.forEach {
                SocialIcon(it.data)
            }
        }
    }
}

@Composable
fun SocialIcon(social: Social) {
    Link(path = social.url, modifier = Modifier.ariaLabel(social.name)) {
        Image(src = "images/${social.icon}", alt = "")
    }
}

val TopHeaderStyle = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .background(
                Background.of(
                    image = BackgroundImage.of(url("../../images/android-header.jpeg")),
                    repeat = BackgroundRepeat.NoRepeat,
                    position = BackgroundPosition.of(CSSPosition.Center),
                    size = BackgroundSize.Cover
                )
            )
            .color(Res.Theme.WHITE.color)
            .textAlign(TextAlign.Center)
            .padding(50.px)
    }
    before {
        Modifier
            .content("")
            .position(Position.Absolute)
            .top(0.px)
            .right(0.px)
            .bottom(0.px)
            .left(0.px)
            .background(Background.Inherit)
            .filter(blur(5.px))
            .zIndex(-1)
    }
    cssRule(" img") {
        Modifier
            .size(150.px)
            .margin(top = 40.px)
    }
    cssRule(" h1") {
        Modifier
            .margin(top = 0.px)
    }
    cssRule(" h2") {
        Modifier
            .margin(20.px)
            .fontSize(20.px)
    }
}

val SocialMediaRowStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Grid)
            .gridAutoFlow(GridAutoFlow.Column)
            .gap(0.px)
            .justifyContent(JustifyContent.Center)
            .zIndex(2)
    }

    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .gap(20.px)
    }

    cssRule(" a") {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .alignItems(AlignItems.Center)
            .size(44.px)
    }
    cssRule(" img") {
        Modifier
            .maxSize(60.percent)
    }
}
