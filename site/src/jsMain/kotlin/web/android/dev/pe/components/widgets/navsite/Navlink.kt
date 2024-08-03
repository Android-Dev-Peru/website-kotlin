package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res

data class Navlink(
    val name: String,
    val path: String
)


@Composable
fun NavLink(item: Navlink, modifier: Modifier = Modifier) {
    Link(path = item.path, modifier.then(NavLinkStyle.toModifier())) {
        Text(item.name)
    }
}

val NavLinkStyle = CssStyle {
    base {
        Modifier
            .fontSize(14.px)
            .lineHeight(20.px)
            .fontWeight(FontWeight.Bold)
            .color(Res.Theme.TEXT.color)
            .textDecorationLine(TextDecorationLine.None)
            .textAlign(TextAlign.Center)
    }
    cssRule(":hover") {
        Modifier
            .color(Color.black)
            .fontWeight(FontWeight.ExtraBold)
            .borderBottom(2.px, LineStyle.Solid, Res.Theme.PRIMARY_LIGHT.color)
            .cursor(Cursor.Pointer)
    }
}