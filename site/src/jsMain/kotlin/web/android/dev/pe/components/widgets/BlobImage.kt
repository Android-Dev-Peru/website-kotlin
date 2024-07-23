package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image

@Composable
fun BlobImage(src: String, blobSrc: String, modifier: Modifier = Modifier) {
    Image(
        src = src,
        alt = "",
        modifier = modifier
            .styleModifier {
                property("-webkit-mask-image", "url($blobSrc)")
                property("-webkit-mask-repeat", "no-repeat")
                property("mask-image", "url($blobSrc)")
                property("mask-repeat", "no-repeat")
            }
    )
}