package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSMediaQuery
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.pages.home.components.sections.*

@Composable
fun Home() {
    Div(Modifier.fillMaxWidth().toAttrs()) {
        TopHeader()
        QuickLinksSection()
        HighlightSection()
        SaveTheDateSection()
        PlaylistsSection()
    }
}

val MobileBreakpoint = CSSMediaQuery.MediaFeature("max-width", 600.px)

