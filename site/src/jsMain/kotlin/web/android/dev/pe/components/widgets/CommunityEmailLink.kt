package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res

@Composable
fun CommunityEmailLink() {
    Link(path = "mailto:${Res.Links.Email}") {
        Text(Res.Links.Email)
    }
}