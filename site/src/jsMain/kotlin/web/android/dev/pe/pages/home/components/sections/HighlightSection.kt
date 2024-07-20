package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import web.android.dev.pe.components.widgets.Card
import web.android.dev.pe.data.CardContent
import web.android.dev.pe.data.Highlights
import web.android.dev.pe.pages.home.MobileBreakpoint
import web.android.dev.pe.pages.home.components.layouts.HomeSection

@Composable
fun HighlightSection() {
    HomeSection(HighlightsSectionStyle.toModifier()) {
        Highlights.forEach {
            HighlightCard(it)
        }
    }
}

@Composable
fun HighlightCard(content: CardContent) {
    Card(
        caption = "Contenido destacado",
        content = content,
        modifier = Modifier.flex(1)
    )
}

val HighlightsSectionStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                size(1.fr)
                size(1.fr)
            }
            .gap(2.em)
            .padding(top = 0.px, bottom = 2.em, leftRight = 2.em)
    }

    cssRule(MobileBreakpoint) {
        Modifier.display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
    }
}
