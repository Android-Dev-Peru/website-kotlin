package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.TouchAction
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.defer.Deferred
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.*
import web.android.dev.pe.Theme
import web.android.dev.pe.get


@Composable
fun Dialog(
    showModal: Boolean,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    if (showModal) {
        Deferred {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(100.vh)
                    .background(Colors.Black.copyf(alpha = 0.8f))
                    .top(window.scrollY.px)
                    .position(Position.Absolute)
                    .touchAction(TouchAction.None) // to prevent scrolling the content below
                    .onClick { onClose() }, // still works fine despite line above
                contentAlignment = Alignment.Center
            ) {
                Box(
                    DialogStyle.toModifier()
                        .then(Modifier.onClick { evt -> evt.stopPropagation() })
                        .then(modifier),
                    contentAlignment = Alignment.TopCenter
                ) {
                    content()
                }
            }
        }
    }
    LaunchedEffect(showModal) {
        if (showModal) {
            disableScroll()
        } else {
            enableScroll()
        }
    }
}

fun disableScroll() {
    window.document.body?.style?.overflowY = "hidden"
}

fun enableScroll() {
    window.document.body?.style?.overflowY = "auto"
}

val DialogStyle = CssStyle {
    base {
        Modifier
            .borderRadius(1.cssRem)
            .backgroundColor(colorMode.get(Theme.surface))
            .maxWidth(80.percent)
            .maxHeight(80.percent)
    }
}
