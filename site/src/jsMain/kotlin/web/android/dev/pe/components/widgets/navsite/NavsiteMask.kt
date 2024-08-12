package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Theme
import web.android.dev.pe.get

@Composable
fun NavsiteMask(visible: Boolean, onClick: ()->Unit) {
    Div(NavsiteMaskStyle.toModifier()
        .display(if (visible) DisplayStyle.Block else DisplayStyle.None)
        .onClick { onClick() }
        .toAttrs()
    )
}

val NavsiteMaskStyle = CssStyle.base {
    Modifier
        .fillMaxSize()
        .backgroundColor(colorMode.get(Theme.navmask))
        .position(Position.Fixed)
        .zIndex(2)
}