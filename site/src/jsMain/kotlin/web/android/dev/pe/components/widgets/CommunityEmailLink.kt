package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res

@Composable
fun CommunityEmailLink(modifier: Modifier = Modifier) {
    Link(
        path = "mailto:${Res.Links.Email}",
        modifier = Modifier
            .color(Colors.DimGray)
            .fontWeight(FontWeight.ExtraBold)
            .then(modifier)
    ) {
        Text(Res.Links.Email)
    }
}