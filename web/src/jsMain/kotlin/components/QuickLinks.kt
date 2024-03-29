package components

import kotlinx.browser.window
import kotlinx.html.DIV
import kotlinx.html.a
import kotlinx.html.div
import kotlinx.html.img
import kotlinx.html.js.onClickFunction

data class QuickLink(
    val title: String,
    val url: String,
    val leftIcon: String,
    val rightIcon: String? = null,
)

fun DIV.quickLink(link: QuickLink, classes: String = "") {
    div(classes = "quick-link $classes") {
        img(
            classes = "left-icon",
            src = "images/${link.leftIcon}",
            alt = "", // no alt text for decorative images
        )
        a("#") { +link.title }
        link.rightIcon?.let {
            img(
                classes = "right-icon",
                src = "images/$it",
                alt = "", // no alt text for decorative images
            )
        }
        onClickFunction = {
            window.open(link.url, "_blank")
        }
    }
}