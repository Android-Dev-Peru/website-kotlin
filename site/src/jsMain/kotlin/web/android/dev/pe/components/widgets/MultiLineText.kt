package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Text

@Composable
fun MultiLineText(text: String) {
    text.split("<br>").forEach {
        Text(it)
        Br()
    }
}