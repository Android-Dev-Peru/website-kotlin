package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.MultiLineText
import web.android.dev.pe.components.widgets.OutlinePrimaryButtonVariant
import web.android.dev.pe.components.widgets.PrimaryButton
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection

@Composable
fun LocationSection(sectionModifier: Modifier = Modifier) {
    ConferenceGridSection(
        sectionModifier = sectionModifier,
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
    H2 { Text(ResStrings.conf_location_title) }
    MultiLineText(ResStrings.conf_location_details)
    PrimaryButton(
        text = ResStrings.conf_location_cta,
        href = Res.Links.Conf.MapUPC,
        variant = OutlinePrimaryButtonVariant,
        modifier = Modifier.margin(top = 16.px)
    )
}

@Composable
private fun LocationMap() {
    Image(
        src = "/events/conf2024/upc_map.webp",
        alt = "Del ingreso, a la izquierda, y bajar las escaleras para ingresar al Pabellon H",
        modifier = Modifier
    )
}