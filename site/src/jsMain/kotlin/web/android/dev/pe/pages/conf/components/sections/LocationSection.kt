package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.MultiLineText
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun LocationSection() {
    ConferenceGridSection(
        header = {
            LocationDetails()
        },
        content = {
            LocationMap()
        }
    )
}

@Composable
private fun LocationDetails() {
    H2 { Text("Ubicación") }
    MultiLineText(
        """
        🏢 Local: UPC Sede Monterrico<br>
        🏟️ Auditorio Bancalari - Pabellón H, primer piso<br>
        🧭 Dirección: Prolongación Primavera 2390, Santiago de Surco<br><br>
        
        ⏰ Hora de ingreso: 8am
        """.trimIndent()
    )
    PrimaryButton(
        text = "Abrir en Maps",
        href = Res.Links.Conf.MapUPC,
        modifier = Modifier.margin(top = 16.px)
    )
}

@Composable
private fun LocationMap() {
    Image(
        src = "images/upc_map.webp",
        alt = "Del ingreso, a la izquierda, y bajar las escaleras para ingresar al Pabellon H",
        modifier = Modifier
    )
}