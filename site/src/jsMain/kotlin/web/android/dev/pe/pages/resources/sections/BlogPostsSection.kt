package web.android.dev.pe.pages.resources.sections

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BorderlessCard
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.data.RecentBlogs
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.HomeGridSection

@Composable
fun BlogPostsSection() {
    HomeGridSection(
        sectionModifier = AlternateBackground,
        header = {
            H2 { Text("Artículos recientes") }
            P { Text("¿Te perdiste algún evento? No hay problema - ponte al día con las últimas novedades de nuestra comunidad") }
            PrimaryButton(text = "Ver todos los artículos", href = Res.Links.DevTo)
        },
        content = {
            blogPosts.forEach {
                BorderlessCard(data = it)
            }
        }
    )
}


private val blogPosts = RecentBlogs.entries.map {
    BorderlessCard(
        title = it.data.title,
        url = it.data.url,
        thumbnail = it.data.thumbnail,
        description = it.data.description,
        caption = "Artículo",
    )
}