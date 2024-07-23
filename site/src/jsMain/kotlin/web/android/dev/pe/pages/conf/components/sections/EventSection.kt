package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.BlobImage
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun EventSection(sectionModifier: Modifier = Modifier) {
    ConferenceGridSection(
        sectionModifier = sectionModifier,
        modifier = Modifier,
        header = {
            Details()
        },
        content = {
            DetailImage()
        }
    )
}

@Composable
private fun Details() {
    H2 { Text("Sobre el evento") }
    P {
        Text("Celebramos 10 años en comunidad compartiendo nuestro amor por Android.")
    }
    P {
        Text("Disfruta de un día lleno de charlas con ponentes internacionales apasionados por esta plataforma. Y al igual que todos nuestros eventos - ")
        SpanText("¡es gratis! 🎉", Modifier.fontWeight(FontWeight.ExtraBold))
    }
    PrimaryButton(
        text = "Regístrarme",
        href = Res.Links.Conf.Register,
        modifier = Modifier.margin(topBottom = 16.px)
    )
}

@Composable
private fun DetailImage() {
    BlobImage(
        src = "images/adp-stock-photo-1.webp",
        blobSrc = "shapes/blob2.svg",
        modifier = Modifier.width(100.percent)
    )
}