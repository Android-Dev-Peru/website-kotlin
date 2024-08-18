package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text


@Composable
fun DecoratedHeading(title: String, href: String) {
    H2(attrs = { id(href) }) {
        HeadingDecorator()
        Text(title)
    }
}