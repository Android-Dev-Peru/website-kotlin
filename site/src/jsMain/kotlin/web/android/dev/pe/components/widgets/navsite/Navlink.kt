package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res

data class Navlink(
    val name: String,
    val path: String
)


@Composable
fun NavLink(item: Navlink, modifier: Modifier = Modifier) {
    Link(path = item.path, modifier.then(NavlinkStyle.toModifier())) {
        Text(item.name)
    }
}

val NavlinkStyle = CssStyle {
    base {
        Modifier
            .fontSize(14.px)
            .lineHeight(20.px)
            .fontWeight(700)
            .color(Res.Theme.TEXT.color)
            .textDecorationLine(TextDecorationLine.None)
            .textAlign(TextAlign.Center)
    }
    cssRule(":hover") {
        Modifier
            .color(Color.black)
            .backgroundColor(Res.Theme.BUTTON_HOVER.color)
            .cursor(Cursor.Pointer)
    }
}