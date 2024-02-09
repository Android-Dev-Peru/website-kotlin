package components

import kotlinx.html.DIV
import kotlinx.html.a
import kotlinx.html.div

fun DIV.primaryButton(text: String, href: String, classes: String = "") {
    a(href = href, classes = "primary-button $classes") { +text }
}