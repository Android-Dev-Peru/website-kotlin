package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.dom.Div

/**
 * This component will render one of two layouts based on the screen size.
 *
 * This component is needed when you need the conditional layout to be applied
 * at first render, rather than delayed until JS is loaded and executed. Using
 * this trick, we avoid a "flicker" effect when the layout is mounted for the
 * first time.
 *
 * @param mobile The layout to render when the screen is small
 * @param large The layout to render when the screen is large
 */
@Composable
fun ConditionalLayout(mobile: @Composable ()-> Unit, large: @Composable ()-> Unit) {
    Div(ConditionalLayoutMobile.toAttrs()) {
        mobile()
    }
    Div(ConditionalLayoutLarge.toAttrs()) {
        large()
    }
}

val ConditionalLayoutMobile = CssStyle {
    base {
        Modifier.display(DisplayStyle.Inherit)
    }
    Breakpoint.MD {
        Modifier.display(DisplayStyle.None)
    }
}
val ConditionalLayoutLarge = CssStyle {
    base {
        Modifier.display(DisplayStyle.None)
    }
    Breakpoint.MD {
        Modifier.display(DisplayStyle.Inherit)
    }
}