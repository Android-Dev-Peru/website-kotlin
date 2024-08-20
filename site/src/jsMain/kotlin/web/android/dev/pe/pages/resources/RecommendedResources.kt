package web.android.dev.pe.pages.resources

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.resources.sections.BlogPostsSection
import web.android.dev.pe.pages.resources.sections.PlaylistsSection

@Page("/resources")
@Composable
fun RecommendedResources() {
    MainSite(lang = Language.Spanish) { Content() }
}

@Page("/resources/en")
@Composable
fun RecommendedResources_EN() {
    MainSite(lang = Language.English) { Content() }
}

@Composable
private fun Content() {
    PlaylistsSection()
    BlogPostsSection()
}