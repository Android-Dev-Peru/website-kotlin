package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.pages.home.components.layouts.SocialIcons

@Composable
fun MainFooter() {
    val isSmallScreen = mutableIsSmallScreen()
    SimpleGrid(numColumns(base = 1, md = 2), MainFooterStyle.toModifier()) {
        if (isSmallScreen) {
            FooterContact()
            FooterSocials()
        } else {
            FooterSocials()
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
        Link(path = "mailto:android@devperu.org") {
            Text("android@devperu.org")
        }
        SocialIcons()
    }
}

@Composable
private fun FooterContact() {
    val isSmallScreen = mutableIsSmallScreen()
    Column(
        modifier = Modifier.gap(12.px).alignSelf(AlignSelf.Center),
        horizontalAlignment = if (isSmallScreen) Alignment.CenterHorizontally else Alignment.End
    ) {
        Div(Modifier.justifyContent(JustifyContent.Center).toAttrs()) {
            Text(ResStrings.main_footer_this_web_is)
            Link(path = Res.Links.GithubWeb) {
                Text(ResStrings.main_footer_open_source)
            }
        }
        Image("/logo.svg", Modifier.size(40.px))
    }
}

val MainFooterStyle = CssStyle {
    base {
        Modifier
            .padding(20.px)
            .gap(12.px)
            .borderTop(1.px, LineStyle.Solid, Res.Theme.BORDER.color)
            .color(Colors.SlateGray)
    }

    Breakpoint.MD {
        Modifier.padding(40.px)
    }

    cssRule(" a") {
        Modifier.color(Colors.DimGray).fontWeight(FontWeight.ExtraBold)
    }
}
