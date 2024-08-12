package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.*
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.px
import web.android.dev.pe.Theme
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.get


@Composable
fun Navsite(navbar: Navbar, content: @Composable () -> Unit) {
    var navbarState by remember { mutableStateOf(NavbarState.Collapsed) }
    val isSmallScreen = mutableIsSmallScreen()

    Box(Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxSize()) {
            Navbar(
                navbar = navbar,
                state = navbarState,
                onDrawerToggle = { navbarState = navbarState.toggle() }
            )
            content()
        }
        NavsiteMask(
            visible = isSmallScreen && navbarState == NavbarState.Expanded,
            onClick = { navbarState = NavbarState.Collapsed }
        )
    }

    if(isSmallScreen) {
        NavsiteDrawer(navbar, navbarState)
    }
}

@Composable
fun LogoAndName(logo: String, name: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Image(
            src = logo,
            modifier = Modifier
                .display(DisplayStyle.InlineBlock)
                .size(40.px)
                .margin(right = 16.px),
        )
        SpanText(
            name,
            modifier = LogoAndNameStyle.toModifier()
        )
    }
}

val LogoAndNameStyle = CssStyle.base {
    Modifier
        .fontSize(14.px)
        .color(colorMode.get(Theme.onSurface))
        .fontWeight(FontWeight.ExtraBold)
        .textDecorationLine(TextDecorationLine.None)
}
