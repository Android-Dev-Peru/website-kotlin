package web.android.dev.pe.pages.articles.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.aspectRatio
import com.varabyte.kobweb.compose.css.boxShadow
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.keywords.auto
import org.jetbrains.compose.web.dom.Iframe

@Composable
fun TalkRecommendationsSlides() {
    Iframe(attrs = {
        classes("speakerdeck-iframe")
        attr("frameborder", "0")
        attr("src", "https://speakerdeck.com/player/0eb0d07b0f8b4e26b85d5c5d9e2e5137")
        attr("title", "Una charla sobre cómo dar una charla técnica")
        attr("allowfullscreen", "true")
        style {
            border(0.px)
            background("padding-box padding-box rgba(0, 0, 0, 0.1)")
            margin(0.px)
            padding(0.px)
            borderRadius(6.px)
            boxShadow("rgba(0, 0, 0, 0.2) 0px 5px 40px")
            width(100.percent)
            height(auto)
            aspectRatio(560,315)
        }
        attr("data-ratio", "1.7777777777777777")
    })
}