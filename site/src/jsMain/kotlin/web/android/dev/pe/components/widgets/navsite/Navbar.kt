package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen

data class Navbar(
    val title: String,
    val logo: String,
    val links: List<Navlink>
)

@Composable
fun Navbar(
    navbar: Navbar,
    onDrawerToggle: ()->Unit
) {
    val isSmallScreen = mutableIsSmallScreen()

    if (isSmallScreen) {
        NavbarMobile(navbar, onClick = { onDrawerToggle() })
    } else {
        NavbarLarge(navbar)
    }
}

@Composable
private fun FakeNavbar() {
    /**
     * This div will occupy the space of the fixed navigation bar,
     * so that the content below it remains scrollable and visible
     */
    Div(Modifier.height(Res.Dimens.NavbarHeight).toAttrs())
}

@Composable
private fun NavbarMobile(navbar: Navbar, onClick: (SyntheticMouseEvent) -> Unit) {
    Row(
        modifier = SharedNavbarStyles.toModifier(),
        horizontalArrangement = Arrangement.spacedBy(16.px),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            src = "icons/hamburger.svg",
            modifier = Modifier.onClick(onClick).cursor(Cursor.Pointer),
            alt = "Abrir menu"
        )
        LogoAndName(logo = navbar.logo, name = navbar.title)
    }
    FakeNavbar()
}


@Composable
private fun NavbarLarge(navbar: Navbar) {
    Row(
        modifier = SharedNavbarStyles.toModifier(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Anchor(
            href = "/",
            attrs = Modifier
                .fillMaxHeight()
                .display(DisplayStyle.Flex)
                .cursor(Cursor.Pointer)
                .textDecorationLine(TextDecorationLine.None)
                .toAttrs()
        ) {
            LogoAndName(logo = navbar.logo, name = navbar.title)
        }
        Row(Modifier.fillMaxHeight()) {
            navbar.links.forEach {
                NavLink(it, Modifier
                    .width(150.px)
                    .fillMaxHeight()
                    .display(DisplayStyle.Flex)
                    .alignItems(AlignItems.Center)
                    .justifyContent(JustifyContent.Center)
                    .padding(leftRight = 16.px)
                )
            }
        }

    }
    FakeNavbar()
}

val SharedNavbarStyles = CssStyle.base {
    Modifier
        .height(Res.Dimens.NavbarHeight)
        .fillMaxWidth()
        .position(Position.Fixed)
        .padding(leftRight = 16.px)
        .backgroundColor(Res.Theme.WHITE.color)
        .borderBottom(1.px, LineStyle.Solid, Res.Theme.BORDER.color)
}