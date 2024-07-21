package web.android.dev.pe.pages.conf.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section

@Composable
fun ConferenceSection(
    modifier: Modifier = Modifier,
    sectionModifier: Modifier = Modifier,
    content: @Composable ()->Unit
) {
    Section(Modifier
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .then(sectionModifier)
        .toAttrs()
    ) {
        Div (Modifier.maxWidth(1000.px).then(modifier).toAttrs()) {
            content()
        }
    }
}