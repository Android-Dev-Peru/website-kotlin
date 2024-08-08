package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.toAttrs
import kotlinx.dom.appendElement
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.Element


/**
 * Using script to load an inline ConvertKit form. For more info see:
 * https://help.convertkit.com/en/articles/4009572-form-embedding-basics#javascript
 */
@Composable
fun ConvertKitForm(uid: String, modifier: Modifier = Modifier) {
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
        .then(modifier)
        .toAttrs()
    )

    LaunchedEffect(containerRef.value) {
        containerRef.value.current?.let { container ->
            container.appendElement("script") {
                setAttribute("async", "")
                setAttribute("data-uid", uid)
                setAttribute("src", "https://android-dev-peru.ck.page/$uid/index.js")
            }
        }
    }
}

private class ContainerRef(val current: Element? = null)
