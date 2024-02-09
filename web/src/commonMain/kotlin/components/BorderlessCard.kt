package components

import kotlinx.html.*

data class BorderlessCard(
    val title: String,
    val url: String,
    val thumbnail: String,
    val caption: String,
    val description: String = "",
)

fun DIV.borderlessCard(content: BorderlessCard, classes: String = "") {
    div(classes = "borderless-card $classes") {
        div(classes = "img-container") {
            a(href = content.url) {
                img(src = content.thumbnail, alt = content.title, classes = "thumbnail")
            }
        }
        div(classes = "content") {
            span { +content.caption }
            a(href = content.url) {
                h3 { +content.title }
            }
            p { +content.description }
        }
    }
}
