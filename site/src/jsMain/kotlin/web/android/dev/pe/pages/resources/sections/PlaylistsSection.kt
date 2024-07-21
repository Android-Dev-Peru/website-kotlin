package web.android.dev.pe.pages.resources.sections

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BorderlessCard
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.data.Playlists
import web.android.dev.pe.pages.home.components.layouts.HomeGridSection

@Composable
fun PlaylistsSection() {
    HomeGridSection(
        header = {
            H2 { Text("Playlists") }
            P { Text("No te pierdas el material exclusivo que la comunidad nos ha compartido a lo largo de lo años.") }
            PrimaryButton(text = "Síguenos en Youtube", href = Res.Links.YouTube)
        },
        content = {
            playlists.forEach {
                BorderlessCard(data = it)
            }
        }
    )
}


private val playlists = Playlists.entries.map {
    BorderlessCard(
        title = it.data.title,
        url = it.data.url,
        thumbnail = it.data.thumbnail,
        description = it.data.description,
        caption = "Playlist",
    )
}