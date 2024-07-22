package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.toMinWidthQuery
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.pages.conf.components.layouts.ConferenceSection
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground


@Composable
fun ConferenceHeader() {
    val styles = ConferenceHeaderStyles
    ConferenceSection(sectionModifier = AlternateBackground) {
        SimpleGrid(numColumns(1, md = 2), styles.container.toModifier()) {
            Column(Modifier.gap(16.px)) {
                SpanText("Android Dev Peru Conf", styles.title.toModifier())
                SpanText("19 de Octubre", styles.details.toModifier())
                SpanText("Lima, UPC Monterrico", styles.details.toModifier())
                SpanText(
                    text = "Celebremos juntos los 10 años de la comunidad, y la llegada de Android 16 🎉",
                    modifier = styles.caption.toModifier()
                )
            }
            Div {
                Image(
                    src = "images/map.png",
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

object ConferenceHeaderStyles {
    val container = CssStyle {
        base {
            Modifier.alignItems(AlignItems.Center)
        }

        cssRule(" span") {
            Modifier.fillMaxWidth().textAlign(TextAlign.Center)
        }
        cssRule(mediaQuery = com.varabyte.kobweb.silk.style.breakpoint.Breakpoint.MD.toMinWidthQuery(), suffix = " span") {
            Modifier.textAlign(TextAlign.Start)
        }
    }
    val title = CssStyle {
        base {
            Modifier
                .fontSize(60.px)
                .fontWeight(FontWeight.ExtraBlack)
                .color(Res.Theme.BLACK.color)
        }
    }
    val caption = CssStyle {
        base {
            Modifier.fontSize(FontSize.XLarge).margin(top = 20.px, bottom = 2.em)
        }
        Breakpoint.MD {
            Modifier.padding(bottom = 4.em)
        }
    }

    val details = CssStyle.base {
        Modifier.fontSize(FontSize.Large)
    }
}