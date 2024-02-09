package components

import kotlinx.html.*
import utils.asSlug

data class CardContent(
    val title: String,
    val description: String,
    val image: String,
    val cta: String,
    val url: String,
)

fun DIV.card(caption: String, content: CardContent, classes: String = "") {
    div(classes = "card $classes") {
        id = "card-${content.title.asSlug()}"
        onClick = "window.location.href = '${content.url}'"

        div(classes = "left-container") {
            span { +caption }
            h3 { unsafe { +content.title } }
            p { unsafe { +content.description } }
            div(classes = "cta-container") {
                a("#") { +content.cta }
            }
        }
        div(classes = "right-container") {
            img(src = "images/${content.image}", alt = content.title) {
                id =  "highlight-image"
            }
        }
    }
}
