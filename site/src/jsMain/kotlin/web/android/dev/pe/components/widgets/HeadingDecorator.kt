package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.silk.components.text.SpanText
import web.android.dev.pe.Res

@Composable
fun HeadingDecorator() {
    SpanText("▮ ", Modifier.color(Res.Theme.PRIMARY_LIGHT.color))
}