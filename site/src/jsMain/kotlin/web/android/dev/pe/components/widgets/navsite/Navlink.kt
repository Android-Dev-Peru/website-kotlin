package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
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
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.components.widgets.RectangularPrimaryButtonVariant

/**
 * Model that represents a navigation option
 * @param path navigation URL
 * @param name option title. It's a function type to lazy load the proper localized text
 */
data class Navlink(
    val path: String,
    val type: Type = Type.Regular,
    val name: () -> String,
) {
    enum class Type { Regular, Highlighted }
}


@Composable
fun NavLink(item: Navlink, modifier: Modifier = Modifier) {
    when (item.type) {
        Navlink.Type.Regular -> RegularNavLink(item, modifier)
        Navlink.Type.Highlighted -> HighlightedNavLink(item, modifier)
    }
}

@Composable
private fun RegularNavLink(item: Navlink, modifier: Modifier = Modifier) {
    Link(path = item.path, modifier.then(NavLinkStyle.toModifier())) {
        Text(item.name())
    }
}


@Composable
private fun HighlightedNavLink(item: Navlink, modifier: Modifier = Modifier) {
    PrimaryButton(
        text = item.name(),
        href = item.path,
        variant = RectangularPrimaryButtonVariant,
        modifier = modifier.height(36.px).margin(leftRight = 4.px).alignSelf(AlignSelf.Center)
    )
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