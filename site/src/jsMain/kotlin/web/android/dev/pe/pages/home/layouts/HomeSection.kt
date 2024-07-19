package web.android.dev.pe.pages.home.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section
import web.android.dev.pe.Res
import web.android.dev.pe.pages.home.HomeSectionStyle

@Composable
fun HomeSection(modifier: Modifier = Modifier, sectionModifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Section(sectionModifier.toAttrs()) {
        Div(HomeSectionStyle.toModifier().then(modifier).toAttrs()) {
            content()
        }
    }
}

val AlternateBackground = Modifier.backgroundColor(Res.Theme.ALTERNATE_BACKGROUND.color)