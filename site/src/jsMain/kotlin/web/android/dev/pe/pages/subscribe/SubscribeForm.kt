package web.android.dev.pe.pages.subscribe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import kotlinx.dom.appendElement
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.Element
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.MainSiteNavbar

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
            ConvertKitForm()
        }
    }
}

/**
 * Using script to load an inline ConvertKit form. For more info see:
 * https://help.convertkit.com/en/articles/4009572-form-embedding-basics#javascript
 */
@Composable
private fun ConvertKitForm() {
    val containerRef = mutableStateOf(ContainerRef())

    Div(Modifier
        .display(DisplayStyle.Flex)
        .justifyContent(JustifyContent.Center)
        .attrsModifier {
            ref {
                containerRef.value = ContainerRef(it)
                onDispose { containerRef.value = ContainerRef(null) }
            }
        }
        .toAttrs()
    )

    LaunchedEffect(containerRef.value) {
        containerRef.value.current?.let { container ->
            container.appendElement("script") {
                setAttribute("async", "")
                setAttribute("data-uid", "f4a99c32b5")
                setAttribute("src", "https://android-dev-peru.ck.page/f4a99c32b5/index.js")
            }
        }
    }
}

private class ContainerRef(val current: Element? = null)