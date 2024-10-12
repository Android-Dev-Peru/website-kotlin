package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.text.SpanText
import web.android.dev.pe.Theme

@Composable
fun HeadingDecorator(color: Color.Rgb = Theme.LIGHT_GREEN) {
    SpanText("▮ ", Modifier.color(color))
}