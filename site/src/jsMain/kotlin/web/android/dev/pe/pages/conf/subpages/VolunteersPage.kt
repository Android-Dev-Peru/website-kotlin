package web.android.dev.pe.pages.conf.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.components.sections.VolunteerSection

@Page("/conf/volunteers")
@Composable
fun VolunteerPage() {
    ConferenceSite(lang = Language.Spanish) {
        VolunteerSection()
    }
}

@Page("/conf/volunteers/en")
@Composable
fun VolunteerPage_EN() {
    ConferenceSite(lang = Language.English) {
        VolunteerSection()
    }
}
