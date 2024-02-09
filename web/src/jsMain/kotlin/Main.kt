import kotlinx.browser.*
import kotlinx.html.*
import kotlinx.html.dom.*
import home.homeContent

fun main() {
    document.body!!.append.div {
        homeContent()
    }
}
