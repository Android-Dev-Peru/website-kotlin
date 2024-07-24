package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.padding
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
import com.varabyte.kobweb.silk.theme.breakpoint.toMinWidthQuery
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.data.Social
import web.android.dev.pe.data.Socials
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection
import web.android.dev.pe.pages.home.components.sections.HomeHeaderStyles.SocialMediaRow

@Composable
fun TopHeader() {
    val isSmallScreen = mutableIsSmallScreen()
    TwoPaneSection(
        sectionModifier = AlternateBackground,
        modifier = HomeHeaderStyles.Container.toModifier(),
        distribution = if (isSmallScreen) 1 to 1 else 2 to 1,
        header = {
            HeaderContent()
        },
        content = {
            HeaderImage()
        }
    )
}
@Composable
private fun HeaderContent() {
    val styles = HomeHeaderStyles
    Column(Modifier.gap(16.px)) {
        SpanText("Android Dev Peru", styles.title.toModifier())
        SpanText(
            text = "Comunidad de desarrolladores Android en Peru y LATAM",
            modifier = styles.caption.toModifier()
        )
        SocialIcons()
    }
}

@Composable
private fun SocialIcons() {
    Div (SocialMediaRow.toAttrs()) {
        Socials.entries.forEach {
            SocialIcon(it.data)
        }
    }
}

@Composable
fun SocialIcon(social: Social) {
    Link(path = social.url, modifier = Modifier.ariaLabel(social.name)) {
        Image(src = social.icon, modifier = HomeHeaderStyles.SocialMediaIcon.toModifier())
    }
}

@Composable
private fun HeaderImage() {
    Div(Modifier.fillMaxSize().display(DisplayStyle.Flex).justifyContent(org.jetbrains.compose.web.css.JustifyContent.Center).toAttrs()) {
        Image(
            src = "logo.svg",
            modifier = HomeHeaderStyles.image.toModifier()
        )
    }
}

object HomeHeaderStyles {
    val Container = CssStyle {
        base {
            Modifier.alignItems(AlignItems.Center).fillMaxWidth().padding(leftRight = 2.em, top = 2.em, bottom = 0.px)
        }
        cssRule(" span") {
            Modifier.fillMaxWidth().textAlign(TextAlign.Center)
        }
        cssRule(mediaQuery = Breakpoint.MD.toMinWidthQuery(), suffix = " span") {
            Modifier.textAlign(TextAlign.Start)
        }
    }

    val title = CssStyle {
        base {
            Modifier
                .fontSize(30.px)
                .fontWeight(FontWeight.ExtraBlack)
                .color(Res.Theme.BLACK.color)
        }

        Breakpoint.MD {
            Modifier.fontSize(60.px).margin(top = 20.px)
        }
    }
    val caption = CssStyle {
        base {
            Modifier.fontSize(FontSize.Large).margin(topBottom = 20.px)
        }
        Breakpoint.MD {
            Modifier.fontSize(FontSize.XLarge)
        }
    }
    val details = CssStyle.base {
        Modifier.fontSize(FontSize.Large)
    }
    val image = CssStyle {
        base {
            Modifier.display(DisplayStyle.None)
        }
        Breakpoint.MD {
            Modifier.display(DisplayStyle.Block).fillMaxWidth().maxWidth(250.px)
        }
    }

    val SocialMediaRow = CssStyle {
        base {
            Modifier
                .fillMaxWidth()
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Row)
                .flexWrap(FlexWrap.Wrap)
                .gap(4.px)
                .justifyContent(JustifyContent.Center)
        }
        Breakpoint.MD {
            Modifier.justifyContent(JustifyContent.Start).gap(8.px)
        }
    }

    val SocialMediaIcon = CssStyle {
        base {
            Modifier.size(40.px).padding(8.px)
        }
        hover {
            Modifier.padding(6.px)
        }
    }
}

