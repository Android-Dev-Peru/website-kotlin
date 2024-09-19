package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.Theme
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.components.widgets.CommunityEmailLink
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.components.widgets.RectangularPrimaryButtonVariant
import web.android.dev.pe.components.widgets.navsite.NavLink
import web.android.dev.pe.components.widgets.navsite.Navlink
import web.android.dev.pe.data.Socials
import web.android.dev.pe.get
import web.android.dev.pe.pages.home.components.layouts.SocialIcons

@Composable
fun MainFooter(extraLinks: List<Navlink> = emptyList()) {
    val isSmallScreen = mutableIsSmallScreen()
    SimpleGrid(
        numColumns = numColumns(base = 1, md = if (extraLinks.isEmpty()) 2 else 3),
        modifier = MainFooterStyle.toModifier()
    ) {
        if (isSmallScreen) {
            FooterExtraLinks(extraLinks)
            FooterContact()
            FooterSocials()
        } else {
            FooterSocials()
            FooterExtraLinks(extraLinks)
            FooterContact()
        }
    }
}

@Composable
private fun FooterSocials() {
    val isSmallScreen = mutableIsSmallScreen()
    Column(
        modifier = Modifier.gap(12.px),
        horizontalAlignment = if (isSmallScreen) Alignment.CenterHorizontally else Alignment.Start
    ) {
        CommunityEmailLink()
        SocialIcons(Socials)
    }
}

@Composable
private fun FooterExtraLinks(extraLinks: List<Navlink>) {
    if(extraLinks.isEmpty()) return
    Div(MainFooterExtraLinksStyle.toAttrs()) {
        extraLinks.forEach {
            NavLink(it)
        }
    }
}

@Composable
private fun FooterContact() {
    val isSmallScreen = mutableIsSmallScreen()
    Column(
        modifier = Modifier.gap(4.px).alignSelf(AlignSelf.Center),
        horizontalAlignment = if (isSmallScreen) Alignment.CenterHorizontally else Alignment.End
    ) {
        PrimaryButton(
            text = ResStrings.main_footer_subscribe,
            href = "/subscribe",
            variant = RectangularPrimaryButtonVariant,
            modifier = Modifier
                .height(36.px)
                .color(Colors.White)
                .display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
        )
        Div(Modifier.justifyContent(JustifyContent.Center).toAttrs()) {
            Text(ResStrings.main_footer_this_web_is)
            Link(path = Res.Links.GithubWeb) {
                Text(ResStrings.main_footer_open_source)
            }
        }
    }
}

val MainFooterStyle = CssStyle {
    base {
        Modifier
            .padding(20.px)
            .gap(12.px)
            .borderTop(1.px, LineStyle.Solid, colorMode.get(Theme.navbarBorder))
    }

    Breakpoint.MD {
        Modifier.padding(40.px)
    }
}

val MainFooterExtraLinksStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(12.px)
            .alignItems(AlignItems.Center)
    }
    Breakpoint.MD {
        Modifier
            .flexDirection(FlexDirection.Row)
            .justifyContent(JustifyContent.Center)
    }
}
