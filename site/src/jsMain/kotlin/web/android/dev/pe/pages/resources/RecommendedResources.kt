package web.android.dev.pe.pages.resources

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.pages.resources.sections.BlogPostsSection
import web.android.dev.pe.pages.resources.sections.PlaylistsSection

@Page("/resources")
@Composable
fun RecommendedResources() {
    MainSite {
        PlaylistsSection()
        BlogPostsSection()
    }
}