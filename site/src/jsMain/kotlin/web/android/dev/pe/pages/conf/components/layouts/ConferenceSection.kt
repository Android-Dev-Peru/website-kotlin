package web.android.dev.pe.pages.conf.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.dom.Section

@Composable
fun ConferenceSection(modifier: Modifier = Modifier, content: @Composable ()->Unit) {
    Section(
        modifier
        .height(80.vh)
        .overflow { y(Overflow.Auto) }
        .minHeight(600.px)
        .toAttrs()
    ) {
        content()
    }
}