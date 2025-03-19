package web.android.dev.pe.pages.conf.year_2024.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section

@Composable
fun ConferenceSection(
    modifier: Modifier = Modifier,
    sectionModifier: Modifier = Modifier,
    content: @Composable ()->Unit
) {
    Section(
        ConferenceSectionStyle2024.toModifier()
        .then(sectionModifier)
        .toAttrs()
    ) {
        Div (Modifier.maxWidth(1200.px).then(modifier).toAttrs()) {
            content()
        }
    }
}

val ConferenceSectionStyle2024 = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .padding(2.em)
    }
    Breakpoint.MD {
        Modifier.padding(top = 4.em, bottom = 0.px, leftRight = 0.px)
    }
    cssRule(" p") {
        Modifier.fontSize(20.px)
    }
}