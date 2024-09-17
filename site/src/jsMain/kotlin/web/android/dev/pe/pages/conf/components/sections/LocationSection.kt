package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaIcon
import com.varabyte.kobweb.silk.components.icons.fa.IconCategory
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.Theme
import web.android.dev.pe.components.CaptionStyle
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.get

@Composable
fun LocationSection(sectionModifier: Modifier = Modifier) {
    Box(LocationSectionStyles.container.toModifier()) {
        Image(
            src = "/events/conf2024/upc_map_large_dark.webp",
            modifier = LocationSectionStyles.map.toModifier()
        )
        Div(LocationSectionStyles.card.toAttrs()) {
            LocationDetails()
        }
    }
}

@Composable
private fun LocationDetails() {
    VenuePicture()
    H2 {
        HeadingDecorator()
        Text("UPC Monterrico")
    }
    val titleModifier = CaptionStyle.then(Modifier.fontWeight(FontWeight.Bold))
    val valueModifier = Modifier.padding(topBottom = 16.px)
    LocationDetailsRow("map") {
        SpanText(ResStrings.conf_location_address, titleModifier)
        Link(path = Res.Links.Conf.MapUPC, openInternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB, modifier = valueModifier) {
            SpanText(ResStrings.conf_location_address_details)
        }
    }
    LocationDetailsRow("building") {
        SpanText(ResStrings.conf_location_place, titleModifier)
        SpanText(ResStrings.conf_location_place_details, valueModifier)
    }
    LocationDetailsRow("clock") {
        SpanText(ResStrings.conf_location_time, titleModifier)
        SpanText(ResStrings.conf_location_time_details, valueModifier)
    }
}

@Composable
private fun LocationDetailsRow(icon: String, content: @Composable ()->Unit) {
    val color = Theme.LIGHT_GREEN
    Row(modifier = Modifier.fillMaxWidth()) {
        FaIcon(icon, Modifier.size(36.px).color(color), IconCategory.REGULAR)
        Column(Modifier.fillMaxWidth()) {
            content()
        }
    }
}

@Composable
private fun VenuePicture() {
    Image(
        src = "/events/conf2024/upc_auditorio".prefixedWithColor(),
        alt = "Del ingreso, a la izquierda, y bajar las escaleras para ingresar al Pabellon H",
        modifier = LocationSectionStyles.picture.toModifier()
    )
}

object LocationSectionStyles {
    val container = CssStyle {
        base {
            Modifier.fillMaxWidth().overflow(Overflow.Hidden)
        }
        Breakpoint.LG {
            Modifier.placeItems(AlignItems.Start, JustifyItems.Start).overflow(Overflow.Unset)
        }
    }
    val map = CssStyle {
        base {
            Modifier.fillMaxHeight()
        }
        Breakpoint.LG {
            Modifier
                .width(100.percent)
        }
    }
    val card = CssStyle {
        base {
            Modifier
                .background(colorMode.get(Theme.surface))
                .color(colorMode.get(Theme.onSurface))
                .position(Position.Relative)
                .overflow(Overflow.Hidden)
                .padding(leftRight = 2.em, bottom = 2.em)
                .boxShadow(0.px, 4.px, 16.px, color = colorMode.get(Theme.shadow))
                .margin(leftRight = 1.em, topBottom = 2.em)
        }
        Breakpoint.LG {
            Modifier
                .top(30.px).left(140.px)
                .margin(0.px)
                .borderRadius(10.px)
        }
    }
    val picture = CssStyle {
        base {
            Modifier.fillMaxWidth().margin(top = 1.em)
        }
        Breakpoint.LG {
            Modifier.height(100.px).width(Width.Unset)
        }
    }
}

@Composable
private fun String.prefixedWithColor(): String {
    val colorMode by ColorMode.currentState
    return when (colorMode) {
        ColorMode.LIGHT -> "${this}_white.webp"
        ColorMode.DARK -> "${this}_dark.webp"
    }
}
