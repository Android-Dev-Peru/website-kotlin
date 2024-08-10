package web.android.dev.pe.pages.resources.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BorderlessCard
import web.android.dev.pe.components.widgets.OutlinePrimaryButtonVariant
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.data.Playlists
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection

@Composable
fun PlaylistsSection() {
    TwoPaneSection(
        header = {
            H2 { Text(ResStrings.resources_playlists_title) }
            P { Text(ResStrings.resources_playlists_description) }
            PrimaryButton(text = ResStrings.resources_playlists_cta, href = Res.Links.YouTube, variant = OutlinePrimaryButtonVariant)
        },
        content = {
            SimpleGrid(numColumns = numColumns(base = 1, md = 2), Modifier.gap(2.em)) {
                playlists.forEach {
                    BorderlessCard(data = it)
                }
            }
        }
    )
}


private val playlists = Playlists.entries.map {
    BorderlessCard(
        title = it.data.title(),
        url = it.data.url,
        thumbnail = it.data.thumbnail,
        description = it.data.description(),
        caption = ResStrings.resources_playlists_caption,
    )
}