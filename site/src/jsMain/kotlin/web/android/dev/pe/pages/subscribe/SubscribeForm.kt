package web.android.dev.pe.pages.subscribe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.MainSiteNavbar
import web.android.dev.pe.components.widgets.ConvertKitForm

/**
 * Hiding the primary action because in this page, the "Subscribe" button
 * from the form should be the primary CTA.
 */
private val CustomNavbar = MainSiteNavbar.copy(primaryLink = null)

@Page("/subscribe")
@Composable
fun SubscribeForm() {
    val colorMode by ColorMode.currentState
    MainSite("es", CustomNavbar) {
        Content(formUid = when(colorMode){
            ColorMode.LIGHT -> "f4a99c32b5"
            ColorMode.DARK -> "cd2b30f4a1"
        })
    }
}

@Page("/subscribe/en")
@Composable
fun SubscribeForm_EN() {
    val colorMode by ColorMode.currentState
    MainSite("en", CustomNavbar) {
        Content(formUid = when(colorMode){
            ColorMode.LIGHT -> "005a4b6e03"
            ColorMode.DARK -> "9557449eeb"
        })
    }
}

@Composable
private fun Content(formUid: String) {
    Div(Modifier.padding(2.em).toAttrs()) {
        ConvertKitForm(formUid)
    }
}