package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.toMinWidthQuery
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import strings.ResStrings
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.data.Socials
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.SocialIcons
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection

@Composable
fun TopHeader() {
    val isSmallScreen = mutableIsSmallScreen()
    TwoPaneSection(
        sectionModifier = AlternateBackground.toModifier(),
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
        SpanText(ResStrings.home_header_title, styles.title.toModifier())
        SpanText(
            text = ResStrings.home_header_caption,
            modifier = styles.caption.toModifier()
        )
        SocialIcons(Socials)
    }
}

@Composable
private fun HeaderImage() {
    Div(Modifier.fillMaxSize().display(DisplayStyle.Flex).justifyContent(org.jetbrains.compose.web.css.JustifyContent.Center).toAttrs()) {
        Image(
            src = "/logo.svg",
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

    val SocialMediaIcon = CssStyle {
        base {
            Modifier.size(40.px).padding(8.px)
        }
        hover {
            Modifier.padding(6.px)
        }
    }
}

