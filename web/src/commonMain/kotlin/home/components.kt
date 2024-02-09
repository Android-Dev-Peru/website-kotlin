package home

import kotlinx.html.*
import utils.asSlug

fun DIV.socialIcon(social: Social) {
    a(href = social.url) {
        attributes["aria-label"] = "Visit us on ${social.name}"
        img(
            src = "images/${social.icon}",
            alt = "" // handling accessibility through parent
        )
    }
}

fun DIV.organizer(organizer: Organizer) {
    div(classes = "organizer-entry") {
        id = "organizer-${organizer.alias ?: organizer.fullName.asSlug()}"
        img {
            src = "images/${organizer.photo}"
            alt = "${organizer.name} ${organizer.lastName}"
        }
        span { +"${organizer.name} ${organizer.lastName}" }
    }

}