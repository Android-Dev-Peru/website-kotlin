package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.Theme
import web.android.dev.pe.colorAwareSVG
import web.android.dev.pe.components.utils.appendCurrentLanguage
import web.android.dev.pe.components.widgets.ConditionalLayout
import web.android.dev.pe.components.widgets.LanguageSelector
import web.android.dev.pe.components.widgets.LanguageSelectorOptions
import web.android.dev.pe.components.widgets.ThemeSwitcher
import web.android.dev.pe.get

data class Navbar(
    val logo: NavbarLogo,
    val primaryLink: Navlink?,
    val secondaryLinks: List<Navlink>,
    val languageSelector: LanguageSelectorOptions,
)

data class NavbarLogo(
    val src: String,
    val title: () -> String,
    val path: String,
)

enum class NavbarState {
    Collapsed, Expanded;

    fun toggle() = when(this) {
        Collapsed -> Expanded
        Expanded -> Collapsed
    }
}

@Composable
fun Navbar(
    navbar: Navbar,
    state: NavbarState,
    onDrawerToggle: ()->Unit
) {
    ConditionalLayout(
        mobile = { NavbarMobile(navbar, state, onClick = { onDrawerToggle() }) },
        large = { NavbarLarge(navbar) }
    )
}

@Composable
fun FakeNavbar() {
    /**
     * This div will occupy the space of the fixed navigation bar,
     * so that the content below it remains scrollable and visible
     */
    Div(Modifier.height(Res.Dimens.NavbarHeight).toAttrs())
}

@Composable
private fun NavbarMobile(
    navbar: Navbar,
    state: NavbarState,
    onClick: (SyntheticMouseEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = SharedNavbarStyles.toModifier().then(modifier),
        horizontalArrangement = Arrangement.spacedBy(16.px),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            src = when(state) {
                NavbarState.Collapsed -> "/icons/hamburger.svg"
                NavbarState.Expanded -> "/icons/close.svg"
            }.colorAwareSVG(),
            modifier = Modifier.onClick(onClick).cursor(Cursor.Pointer),
            alt = if (state == NavbarState.Collapsed) "Abrir menu" else "Cerrar menu"
        )
        Anchor(
            href = navbar.logo.path.appendCurrentLanguage(),
            attrs = NavbarLogoLinkStyle.toAttrs()
        ) {
            LogoAndName(logo = navbar.logo.src, name = navbar.logo.title())
        }
        Spacer()
        ThemeSwitcher()
    }
    FakeNavbar()
}


@Composable
private fun NavbarLarge(navbar: Navbar, modifier: Modifier = Modifier) {
    Row(
        modifier = SharedNavbarStyles.toModifier().then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Anchor(
            href = navbar.logo.path.appendCurrentLanguage(),
            attrs = Modifier
                .fillMaxHeight()
                .display(DisplayStyle.Flex)
                .then(NavbarLogoLinkStyle.toModifier())
                .toAttrs()
        ) {
            LogoAndName(logo = navbar.logo.src, name = navbar.logo.title())
        }
        Row(Modifier.fillMaxHeight()) {
            ThemeSwitcher()
            navbar.secondaryLinks.forEach {
                NavLink(it, NavbarLargeItemStyle.toModifier())
            }
            navbar.primaryLink?.let {
                HighlightedNavLink(it, NavbarLargeItemStyle.toModifier())
            }
            LanguageSelector(navbar.languageSelector, NavbarLanguageSelectorStyle.toModifier())
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
        .backgroundColor(colorMode.get(Theme.navbar))
        .borderBottom(1.px, LineStyle.Solid, colorMode.get(Theme.navbarBorder))
        .zIndex(4)
}

val NavbarLargeItemStyle = CssStyle.base {
    Modifier
        .fillMaxHeight()
        .display(DisplayStyle.Flex)
        .alignItems(AlignItems.Center)
        .justifyContent(JustifyContent.Center)
        .padding(leftRight = 16.px)
}

val NavbarLanguageSelectorStyle = CssStyle.base {
    Modifier
        .alignSelf(AlignSelf.Center)
        .height(36.px).margin(left = 4.px)
}

val NavbarLogoLinkStyle = CssStyle.base {
    Modifier
        .cursor(Cursor.Pointer)
        .textDecorationLine(TextDecorationLine.None)
}