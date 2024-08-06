package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import web.android.dev.pe.components.widgets.LanguageSelector

@Composable
fun NavsiteDrawer(
    navbar: Navbar,
    state: NavbarState,
) {
    val animationStyle = if (state == NavbarState.Expanded) DrawerOpenStyle else DrawerClosedStyle
    val containerStyle = DrawerStyle.toModifier().then(animationStyle.toModifier())

    Column(containerStyle, horizontalAlignment = Alignment.CenterHorizontally) {
        /**
         * Given that the drawer display from top to bottom, we need an element that occupies the
         * space of the fixed navigation bar, so that the content below it remains visible.
         */
        FakeNavbar()

        navbar.secondaryLinks.forEach {
            DrawerNavlink(it)
        }
        navbar.primaryLink?.let {
            DrawerHighlightedNavlink(it)
        }
        LanguageSelector(navbar.languageSelector, DrawerElementStyle.toModifier())
    }
}

@Composable
private fun DrawerNavlink(link: Navlink) {
    NavLink(link, DrawerElementStyle.toModifier())
}

@Composable
private fun DrawerHighlightedNavlink(link: Navlink) {
    HighlightedNavLink(link, DrawerElementStyle.toModifier())
}

val DrawerStyle = CssStyle.base {
    Modifier
        .fillMaxWidth()
        .padding(bottom = 16.px)
        .backgroundColor(Colors.White)
        .position(Position.Fixed)
        .zIndex(3)
}

val DrawerClosedStyle = CssStyle.base {
    Modifier
        .transform { translateY((-100).percent) }
        .transition(Transition.of("transform", 0.2.s, TransitionTimingFunction.EaseInOut))
}

val DrawerOpenStyle = CssStyle.base {
    Modifier
        .transform { translateY(0.px) }
        .transition(Transition.of("transform", 0.2.s, TransitionTimingFunction.EaseInOut))
}

val DrawerElementStyle = CssStyle.base {
    Modifier
        .height(52.px)
        .fontSize(FontSize.Medium)
        .padding(16.px)
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
}