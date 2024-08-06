package web.android.dev.pe.pages.aboutus.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.data.Organizer
import web.android.dev.pe.data.Organizers
import web.android.dev.pe.data.LegacyOrganizers
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.TwoPaneSection

@Composable
fun OrganizersSection() {
    OrganizersWrapper(
        sectionModifier = AlternateBackground,
        data = Organizers.entries.map { it.data },
        title = "Equipo organizador",
        caption = "Ellos son quienes se encargan de mantener la comunidad activa mes a mes.",
    )
}

@Composable
fun LegacyOrganizersSection() {
    OrganizersWrapper(
        data = LegacyOrganizers.entries.map { it.data },
        title = "Equipo legacy",
        caption = "Si bien ya no nos acompañan en el equipo, agradecemos mucho el apoyo de nuestros organizadores retirados ❤️"
    )
}

@Composable
private fun OrganizersWrapper(
    sectionModifier: Modifier = Modifier,
    title: String,
    caption: String,
    data: List<Organizer>,
) {
    TwoPaneSection(
        sectionModifier = sectionModifier,
        distribution = 1 to 1,
        header = {
            H2 { Text(title) }
            P { Text(caption) }
        },
        content = {
            SimpleGrid(numColumns(base = 2, md = 4)) {
                data.forEach {
                    Organizer(it)
                }
            }
        }
    )
}

@Composable
private fun Organizer(organizer: Organizer) {
    Column(Modifier.gap(10.px).margin(20.px), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(src = "/images/${organizer.photo}", Modifier.size(90.px).borderRadius(50.percent).boxShadow(0.px, 0.px, 10.px, color = rgba(0, 0, 0, 0.5f)))
        SpanText("${organizer.name} ${organizer.lastName}", Modifier.textAlign(TextAlign.Center))
    }
}
