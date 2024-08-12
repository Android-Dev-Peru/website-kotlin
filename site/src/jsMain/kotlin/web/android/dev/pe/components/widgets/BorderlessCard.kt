package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.navigation.Anchor
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Theme
import web.android.dev.pe.get

data class BorderlessCard(
    val title: String,
    val url: String,
    val thumbnail: String,
    val caption: String,
    val description: String = "",
)

@Composable
fun BorderlessCard(data: BorderlessCard, modifier: Modifier = Modifier) {
    val styles = BorderlessCardStyles
    Div(styles.Card.toAttrs()) {
        Div(styles.ImageContainer.toAttrs()) {
            Anchor(href = data.url) {
                Image(
                    src = data.thumbnail,
                    alt = data.title,
                    modifier = styles.Image.toModifier()
                )
            }
        }
        Div {
            SpanText(data.caption)
            Anchor(href = data.url) {
                H3 { Text(data.title) }
            }
            P {
                Text(data.description)
            }
        }
    }
}

object BorderlessCardStyles {
    val ImageContainer = CssStyle {
        base {
            Modifier
                .position(Position.Relative)
                .fillMaxWidth()
                .height(0.px)
                .overflow(Overflow.Hidden)
                .boxSizing(BoxSizing.BorderBox)
                .borderRadius(24.px, 24.px, 0.px, 0.px)
                .margin(bottom = 16.px)
                .padding(bottom = 56.25.percent)
        }
    }

    val Image = CssStyle(
        extraModifier = Modifier.attrsModifier { attr("object-position", "center") }
    ) {
        base {
            Modifier
                .position(Position.Absolute)
                .top(0.px)
                .left(0.px)
                .objectFit(ObjectFit.Cover)
                .fillMaxSize()
        }
    }

    val Card = CssStyle {
        cssRule(" h3") {
            Modifier
                .margin(16.px, 0.px)
        }
        cssRule(" a") {
            Modifier
                .color(colorMode.get(Theme.onSurface))
                .textDecorationLine(TextDecorationLine.None)
        }
        cssRule(" a:hover") {
            Modifier
                .cursor(Cursor.Pointer)
                .color(colorMode.get(Theme.link))
        }
        cssRule(" p") {
            Modifier
                .color(colorMode.get(Theme.onBackground))
        }
    }
}
