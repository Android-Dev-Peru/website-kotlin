package web.android.dev.pe.pages.home.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.navigation.RoutePrefix
import kotlinx.browser.window
import org.jetbrains.compose.web.css.em
import web.android.dev.pe.pages.conf.components.widgets.ConferenceCard
import web.android.dev.pe.pages.home.layouts.AlternateBackground
import web.android.dev.pe.pages.home.layouts.HomeSection

@Composable
fun SaveTheDateSection() {
    HomeSection(
        sectionModifier = AlternateBackground,
        modifier = Modifier.padding(4.em)
    ) {
        ConferenceCard(
            Modifier
                .onClick { window.open(RoutePrefix.prepend( "/conf"), "_self") }
                .cursor(Cursor.Pointer)
        )
    }
}
