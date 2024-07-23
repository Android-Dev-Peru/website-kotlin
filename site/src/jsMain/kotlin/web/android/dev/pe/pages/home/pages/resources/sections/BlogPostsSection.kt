package web.android.dev.pe.pages.home.pages.resources.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BorderlessCard
import web.android.dev.pe.components.widgets.OutlinePrimaryButtonVariant
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.data.RecentBlogs
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection

@Composable
fun BlogPostsSection() {
    TwoPaneSection(
        sectionModifier = AlternateBackground,
        header = {
            H2 { Text("Artículos recientes") }
            P { Text("¿Te perdiste algún evento? No hay problema - ponte al día con las últimas novedades de nuestra comunidad") }
            PrimaryButton(text = "Ver todos los artículos", href = Res.Links.DevTo, variant = OutlinePrimaryButtonVariant)
        },
        content = {
            SimpleGrid(numColumns = numColumns(2), Modifier.gap(2.em)) {
                blogPosts.forEach {
                    BorderlessCard(data = it)
                }
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