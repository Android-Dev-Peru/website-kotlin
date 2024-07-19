package web.android.dev.pe.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.pages.home.QuickLinksSection
import web.android.dev.pe.pages.home.TopHeader

@Page
@Composable
fun HomePage() {
    Div(Modifier.fillMaxWidth().toAttrs()) {
        TopHeader()
        QuickLinksSection()
        SaveTheDate()
        HighlightSection()
    }
}

@Composable
fun HighlightSection() {

}

@Composable
fun SaveTheDate() {

}
