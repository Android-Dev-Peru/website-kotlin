package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.data.Social
import web.android.dev.pe.data.Socials
import web.android.dev.pe.pages.home.MobileBreakpoint

@Composable
fun TopHeader() {
    val socials = Socials.entries
    Div(HomeHeaderStyles.Container.toAttrs()) {
        Image(
            src = "logo.svg",
            modifier = HomeHeaderStyles.Image.toModifier()
        )
        H1(Modifier.margin(top = 0.px).toAttrs()) {
            Text("Android Dev Peru")
        }
        P(HomeHeaderStyles.Hint.toAttrs()) {
            Text("Comunidad de desarrolladores Android en Peru y LATAM")
        }
        Div(HomeHeaderStyles.SocialMediaRow.toModifier().toAttrs()) {
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

object HomeHeaderStyles {
    val Container = CssStyle {
        base {
            Modifier
                .color(Res.Theme.WHITE.color)
                .textAlign(TextAlign.Center)
                .padding(50.px)
                .background(Background.of(
                    image = BackgroundImage.of(url("images/android-header-blur.jpeg")),
                    repeat = BackgroundRepeat.NoRepeat,
                    position = BackgroundPosition.of(CSSPosition.Center),
                    size = BackgroundSize.Cover
                ))
        }
    }

    val Image = CssStyle {
        base {
            Modifier
                .size(150.px)
                .margin(top = 40.px)
        }
        cssRule(MobileBreakpoint) {
            Modifier.display(DisplayStyle.None)
        }
    }

    val Title = CssStyle {
        base {
            Modifier
                .margin(top = 0.px)
                .fontSize(60.px)
        }
        cssRule(MobileBreakpoint) { Modifier.fontSize(30.px) }
    }

    val Hint = CssStyle {
        base {
            Modifier
                .margin(20.px)
                .fontSize(20.px)
        }
        cssRule(MobileBreakpoint) { Modifier.fontSize(14.px) }
    }

    val SocialMediaRow = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Grid)
                .gridAutoFlow(GridAutoFlow.Column)
                .gap(0.px)
                .justifyContent(JustifyContent.Center)
        }
//
//    Breakpoint.MD {
//        Modifier
//            .display(DisplayStyle.Flex)
//            .flexDirection(FlexDirection.Row)
//            .gap(20.px)
//    }

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
}

