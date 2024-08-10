package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import strings.ResStrings
import web.android.dev.pe.components.widgets.Card
import web.android.dev.pe.data.CardContent
import web.android.dev.pe.data.Highlights
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
        caption = ResStrings.home_highlights_card_title,
        content = content,
        modifier = Modifier.flex(1).fillMaxHeight()
    )
}

val HighlightsSectionStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(2.em)
            .padding(top = 0.px, bottom = 2.em, leftRight = 2.em)
    }

    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                size(1.fr)
                size(1.fr)
            }
    }
}
