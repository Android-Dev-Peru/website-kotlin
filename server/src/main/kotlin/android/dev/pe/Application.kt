package android.dev.pe

import home.homeContent
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import kotlinx.html.*

const val SERVER_PORT = 8080

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        staticResources("/images", "images")
        staticResources("/styles", "styles")
        staticResources("/events", "events")
        get("/") {
            call.respondHtml {
                home()
            }
        }
    }
}

private fun HTML.home() {
    defaultPage(
        customHead = {
            link(rel = "stylesheet", href = "styles/screens/home.css")
        },
        customBody = {
            div {
                homeContent()
            }
        }
    )
}

private fun HTML.defaultPage(customHead: HEAD.()->Unit = {}, customBody: BODY.() -> Unit) {
    head {
        title { +"Android Dev Peru" }
        meta(name = "viewport", content = "width=device-width, initial-scale=1.0")
        meta(name = "description", content = "Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
        meta(name = "author", content = "Android Dev Peru")
        link(rel = "icon", href = "images/logo.svg", type = "image/svg+xml")
        link(rel = "stylesheet", href = "styles/global.css")
        link(rel = "stylesheet", href = "https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap", type = "text/css")
        customHead()
    }
    body {
        customBody()
    }
}
