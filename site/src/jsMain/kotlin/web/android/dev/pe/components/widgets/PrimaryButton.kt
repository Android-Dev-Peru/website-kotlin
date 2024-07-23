package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res

@Composable
fun PrimaryButton(
    text: String,
    href: String,
    variant: CssStyleVariant<PrimaryButtonKind> = FilledPrimaryButtonVariant,
    modifier: Modifier = Modifier
) {
    Anchor(href = href, attrs = modifier.then(PrimaryButtonStyle.toModifier(variant)).toAttrs()) {
        Text(text)
    }
}

sealed interface PrimaryButtonKind : ComponentKind
val PrimaryButtonStyle = CssStyle<PrimaryButtonKind> {
    base {
        Modifier
            .padding(20.px)
            .textAlign(TextAlign.Center)
            .textDecorationLine(TextDecorationLine.None)
            .display(DisplayStyle.InlineBlock)
            .fontSize(16.px)
            .margin(4.px, 2.px)
            .cursor(Cursor.Pointer)
            .borderRadius(40.px)
    }
    hover {
        Modifier
            .backgroundColor(Res.Theme.BUTTON_HOVER.color)
            .color(Colors.Black)
    }
}

val FilledPrimaryButtonVariant = PrimaryButtonStyle.addVariant {
    base {
        Modifier
            .backgroundColor(Res.Theme.PRIMARY_BUTTON.color)
            .color(Res.Theme.ON_PRIMARY_BUTTON.color)
            .border { style(LineStyle.None) }
    }
    hover {
        Modifier
            .backgroundColor(Res.Theme.BUTTON_HOVER.color)
            .color(Colors.Black)
    }
}

val OutlinePrimaryButtonVariant = PrimaryButtonStyle.addVariant {
    base {
        Modifier
            .border(2.px, LineStyle.Solid, Colors.Black)
            .borderRadius(96.px)
            .color(Colors.Black)
    }
    hover {
        Modifier
            .backgroundColor(Colors.Black)
            .color(Colors.White)
    }
}