package web.android.dev.pe.pages.conf.year_2024.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.core.Page
import web.android.dev.pe.pages.conf.year_2024.ConferenceSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.conf.year_2024.components.sections.VolunteerSection

@Page("/conf/2024/volunteers")
@Composable
fun VolunteerPage() {
    ConferenceSite(lang = Language.Spanish) {
        VolunteerSection()
    }
}

@Page("/conf/2024/volunteers/en")
@Composable
fun VolunteerPage_EN() {
    ConferenceSite(lang = Language.English) {
        VolunteerSection()
    }
}
