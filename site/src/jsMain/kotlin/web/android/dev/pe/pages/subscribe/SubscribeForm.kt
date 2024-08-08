package web.android.dev.pe.pages.subscribe

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
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
    MainSite(CustomNavbar) {
        Div(Modifier.padding(2.em).toAttrs()) {
            ConvertKitForm(uid = "f4a99c32b5")
        }
    }
}
