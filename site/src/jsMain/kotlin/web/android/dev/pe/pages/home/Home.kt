package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import web.android.dev.pe.pages.home.components.sections.HighlightSection
import web.android.dev.pe.pages.home.components.sections.QuickLinksSection
import web.android.dev.pe.pages.home.components.sections.SaveTheDateSection
import web.android.dev.pe.pages.home.components.sections.TopHeader

@Composable
fun Home() {
    TopHeader()
    QuickLinksSection()
    HighlightSection()
    SaveTheDateSection()
}
