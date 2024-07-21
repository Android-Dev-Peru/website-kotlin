package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.Div

@Composable
fun NavsiteMask(visible: Boolean, onClick: ()->Unit) {
    Div(Modifier
        .fillMaxSize()
        .backgroundColor(rgba(0,0,0, 0.4))
        .position(Position.Fixed)
        .display(if (visible) DisplayStyle.Block else DisplayStyle.None)
        .onClick { onClick() }
        .toAttrs()
    )
}