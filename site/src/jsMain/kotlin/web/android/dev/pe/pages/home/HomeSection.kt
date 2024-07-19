package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.alignItems
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section

@Composable
fun HomeSection(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Section {
        Div(HomeSectionStyle.toModifier().then(modifier).toAttrs()) {
            content()
        }
    }
}

val HomeSectionStyle = CssStyle.base {
    Modifier
        .maxWidth(1200.px)
        .alignItems(AlignItems.Center)
        .margin(leftRight = autoLength)
}