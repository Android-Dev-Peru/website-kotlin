package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.Br

@Composable
fun MultiLineText(text: String, modifier: Modifier = Modifier) {
    text.split("<br>").forEach {
        SpanText(it, modifier)
        Br()
    }
}