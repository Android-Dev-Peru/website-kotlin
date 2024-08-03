package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import web.android.dev.pe.Res

@Composable
fun NavsiteDrawer(
    navbar: Navbar,
    opened: Boolean,
    onDrawerClose: ()->Unit,
) {
    val animationStyle = if (opened) DrawerOpenStyle else DrawerClosedStyle
    val containerStyle = DrawerStyle.toModifier().then(animationStyle.toModifier())

    Column(containerStyle) {
        Header(navbar, onDrawerClose)
        navbar.links.forEach {
            DrawerNavlink(it)
        }
    }
}

@Composable
private fun Header(navbar: Navbar, onDrawerClose: ()->Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(leftRight = 16.px)
            .height(Res.Dimens.NavbarHeight)
            .borderBottom(1.px, LineStyle.Solid, rgb(232, 234, 237)),
        horizontalArrangement = Arrangement.spacedBy(16.px),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            src = "icons/close.svg",
            alt = "Cerrar menu",
            modifier = Modifier.onClick { onDrawerClose() }.cursor(Cursor.Pointer)
        )
        LogoAndName(logo = navbar.logo, name = navbar.title)
    }
}

@Composable
private fun DrawerNavlink(link: Navlink) {
    NavLink(link, Modifier
        .height(52.px)
        .fontSize(FontSize.Medium)
        .fillMaxWidth()
        .padding(left = 16.px)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
    )
}

val DrawerStyle = CssStyle.base {
    Modifier
        .fillMaxHeight()
        .width(350.px)
        .backgroundColor(Colors.White)
        .position(Position.Fixed)
        .zIndex(3)
}

val DrawerClosedStyle = CssStyle.base {
    Modifier
        .transform { translateX((-100).percent) }
        .transition(Transition.of("transform", 0.2.s, TransitionTimingFunction.EaseInOut))
}

val DrawerOpenStyle = CssStyle.base {
    Modifier
        .transform { translateX(0.px) }
        .transition(Transition.of("transform", 0.2.s, TransitionTimingFunction.EaseInOut))
}
