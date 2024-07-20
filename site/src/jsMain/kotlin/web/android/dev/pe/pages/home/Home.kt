package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.CSSMediaQuery
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.pages.home.sections.*

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

