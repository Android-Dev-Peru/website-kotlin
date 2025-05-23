package web.android.dev.pe.pages.home.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.navigation.BasePath
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.pages.conf.year_2024.components.widgets.ConferenceCard
import web.android.dev.pe.pages.conf.year_2024.components.widgets.ShinyCardStyles2024
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.HomeSection

@Composable
fun SaveTheDateSection() {
    HomeSection(
        sectionModifier = AlternateBackground.toModifier(),
        modifier = Modifier.padding(4.em)
    ) {
        ConferenceCard(
            Modifier
                .onClick { window.open(BasePath.prepend( "/conf"), "_self") }
                .cursor(Cursor.Pointer)
        ) {
            H3(ShinyCardStyles2024.Title.toAttrs()) { Text(ResStrings.conf_title.uppercase()) }
            P(ShinyCardStyles2024.Hint.toAttrs()) { Text(ResStrings.home_save_the_date) }
            P(ShinyCardStyles2024.Hint.toAttrs()) { Text(ResStrings.home_save_the_date_location) }
        }
    }
}
