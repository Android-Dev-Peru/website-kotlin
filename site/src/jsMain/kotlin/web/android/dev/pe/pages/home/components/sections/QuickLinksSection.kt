package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.toMinWidthQuery
import com.varabyte.kobweb.silk.theme.breakpoint.toWidth
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.data.QuickLink
import web.android.dev.pe.data.QuickLinks
import web.android.dev.pe.pages.home.MobileBreakpoint
import web.android.dev.pe.pages.home.components.layouts.HomeSection

@Composable
fun QuickLinksSection() {
    HomeSection(QuickLinksSectionStyle.toModifier()) {
        QuickLinks.entries.forEach {
            QuickLinkItem(it.data)
        }
    }
}

@Composable
fun QuickLinkItem(quickLink: QuickLink) {
    Div(
        QuickLinkItemStyle
        .toModifier()
        .onClick { window.open(quickLink.url, "_blank") }
        .toAttrs()
    ) {
        Image(
            src = "images/${quickLink.leftIcon}",
            modifier = Modifier.classNames("left-icon"),
            alt = "", // no alt text for decorative images
        )
        Link(path = quickLink.url) {
            Text(quickLink.title)
        }
        quickLink.rightIcon?.let {
            Image(
                src = "images/$it",
                modifier = Modifier
                    .classNames("right-icon")
                    .onClick { window.open(quickLink.url, "_blank") },
                alt = "", // no alt text for decorative images
            )
        }
    }
}

val QuickLinksSectionStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .gap(2.em)
            .padding(2.em)
    }

    cssRule(MobileBreakpoint) {
        Modifier
            .flexDirection(FlexDirection.Column)
            .padding(topBottom = 2.em, leftRight = 1.em)
    }
}

val QuickLinkItemStyle = CssStyle {
    base {
        Modifier
            .flex(1)
            .border(2.px, LineStyle.Solid, Res.Theme.BORDER.color)
            .borderRadius(96.px)
            .padding(24.px)
            .cursor(Cursor.Pointer)
            .display(DisplayStyle.Flex)
            .alignItems(AlignItems.Center)
            .boxShadow(0.px, 2.px, 8.px, color = rgba(0, 0, 0, 0.1f))
    }
    hover {
        Modifier
            .backgroundColor(Res.Theme.BUTTON_HOVER.color)
            .color(Res.Theme.WHITE.color)
    }
    cssRule(" .left-icon") {
        Modifier
            .maxHeight(30.px)
            .alignSelf(AlignSelf.Center)
            .margin(right = 16.px)
    }
    cssRule(" .right-icon") {
        Modifier
            .maxHeight(30.px)
            .alignSelf(AlignSelf.Center)
            .margin(left = autoLength)
    }
    cssRule(" a") {
        Modifier
            .color(Res.Theme.BLACK.color)
            .fontSize(18.px)
            .fontWeight(500)
            .textDecorationLine(TextDecorationLine.None)
            .alignSelf(AlignSelf.Center)
    }

    cssRule(MobileBreakpoint) {
        Modifier.flex(1).fillMaxWidth()
    }
}
