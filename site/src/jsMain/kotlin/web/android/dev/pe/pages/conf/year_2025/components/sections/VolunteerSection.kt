package web.android.dev.pe.pages.conf.year_2025.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flex
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.components.widgets.CommunityEmailLink
import web.android.dev.pe.components.widgets.DecoratedHeading
import web.android.dev.pe.data.Volunteers_AndroidConf2025
import web.android.dev.pe.pages.aboutus.sections.Organizer
import web.android.dev.pe.pages.conf.year_2025.components.layouts.ConferenceGridSection

@Composable
fun VolunteerSection() {
    ConferenceGridSection(
        header = {
            DecoratedHeading(ResStrings.conf_2025_volunteers_title, "volunteers")
            P { Text(ResStrings.conf_2025_volunteers_caption) }
            P(VolunteerSectionStyles.description.toAttrs()) {
                Text(ResStrings.conf_2025_volunteers_join)
                CommunityEmailLink()
            }

        },
        content = {
            SimpleGrid(numColumns(2, lg = 4), VolunteerSectionStyles.volunteers.toModifier()) {
                Volunteers_AndroidConf2025.forEach {
                    Organizer(it)
                }
            }
        },
        contentModifier = Modifier.flex(1)
    )
}

object VolunteerSectionStyles {
    val description = CssStyle {
        base { Modifier.margin(bottom = 1.em) }
        Breakpoint.MD { Modifier.margin(bottom = 4.em) }
    }
    val volunteers = CssStyle {
        base { Modifier.fillMaxWidth().margin(8.px) }
        Breakpoint.MD { Modifier.margin(2.em) }
    }
}
