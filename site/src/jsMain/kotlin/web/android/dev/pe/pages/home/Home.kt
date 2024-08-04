package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.CSSMediaQuery
import org.jetbrains.compose.web.css.px
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.pages.home.components.sections.*

@Composable
fun Home() {
    MainSite {
        TopHeader()
        QuickLinksSection()
        HighlightSection()
        SaveTheDateSection()
    }
}
