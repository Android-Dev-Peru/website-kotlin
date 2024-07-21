package web.android.dev.pe.components.breakpoints

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.breakpointFloor
import kotlinx.browser.window
import org.w3c.dom.events.EventListener


@Composable
fun mutableIsSmallScreen() = produceState(window.breakpointFloor < Breakpoint.MD) {
    val resizeListener = EventListener { value = window.breakpointFloor < Breakpoint.MD }

    window.addEventListener("resize", resizeListener)
    awaitDispose {
        window.removeEventListener("resize", resizeListener)
    }
}.value