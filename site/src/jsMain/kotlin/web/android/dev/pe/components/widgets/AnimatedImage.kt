package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.dom.Source
import org.jetbrains.compose.web.dom.Video

private class VideoRef(val current: dynamic = null)

@Composable
fun AnimatedImage(src: String, modifier: Modifier = Modifier) {

    when(src.split(".").last()) {
        "gif" -> {
            Image(
                src = src,
                modifier = modifier
            )
        }
        "webm" -> {
            val videoRef = mutableStateOf(VideoRef())
            Video(
                Modifier
                .attrsModifier {
                    attr("autoplay", "true")
                    attr("loop", "true")
                    attr("muted", "muted")
                    attr("playsinline", "true")
                    ref {
                        videoRef.value = VideoRef(it)
                        onDispose { videoRef.value = VideoRef(null) }
                    }
                }.then(modifier)
                .toAttrs()
            ) {
                Source(attrs = {
                    attr("src", src)
                    attr("type", "video/webm")
                })
            }
            LaunchedEffect(videoRef.value) {
                if (videoRef.value.current != null) {
                    videoRef.value.current.muted = true
                    videoRef.value.current.play()
                }
            }
        }
        else -> console.log("Unsupported animated image format: $src")
    }
}