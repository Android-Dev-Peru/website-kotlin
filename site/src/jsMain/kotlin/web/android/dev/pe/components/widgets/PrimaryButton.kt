package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.style.*
import com.varabyte.kobweb.silk.style.selectors.hover
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Theme
import web.android.dev.pe.get

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
}

val FilledPrimaryButtonVariant = PrimaryButtonStyle.addVariant {
    base {
        Modifier
            .backgroundColor(colorMode.get(Theme.primary))
            .color(colorMode.get(Theme.onPrimary))
            .border { style(LineStyle.None) }
    }
    hover {
        Modifier
            .backgroundColor(colorMode.get(Theme.secondary))
            .color(colorMode.get(Theme.onSecondary))
    }
}

val OutlinePrimaryButtonVariant = PrimaryButtonStyle.addVariant {
    base {
        Modifier
            .border(2.px, LineStyle.Solid, colorMode.get(Theme.onBackground))
            .borderRadius(96.px)
            .color(colorMode.get(Theme.onBackground))
    }
    hover {
        Modifier
            .backgroundColor(colorMode.get(Theme.onSurface))
            .color(colorMode.get(Theme.surface))
    }
}


val RectangularPrimaryButtonVariant = PrimaryButtonStyle.addVariant {
    base {
        Modifier
            .backgroundColor(colorMode.get(Theme.primary))
            .color(colorMode.get(Theme.onPrimary))
            .border { style(LineStyle.None) }
            .fontSize(14.px)
            .borderRadius(4.px)
    }
    hover {
        Modifier
            .backgroundColor(colorMode.get(Theme.secondary))
            .color(colorMode.get(Theme.onSecondary))
    }
}