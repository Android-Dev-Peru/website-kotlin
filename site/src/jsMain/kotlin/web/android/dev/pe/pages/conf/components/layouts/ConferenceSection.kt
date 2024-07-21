package web.android.dev.pe.pages.conf.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Row
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
    Section(ConferenceSectionStyle.toModifier()
        .then(sectionModifier)
        .toAttrs()
    ) {
        Div (Modifier.maxWidth(1000.px).then(modifier).toAttrs()) {
            content()
        }
    }
}

val ConferenceSectionStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .justifyContent(JustifyContent.Center)
            .padding(2.em)
    }
    Breakpoint.MD {
        Modifier.padding(top = 4.em, bottom = 0.px, leftRight = 0.px)
    }
}