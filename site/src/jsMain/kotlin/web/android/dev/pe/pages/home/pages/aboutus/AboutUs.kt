package web.android.dev.pe.pages.home.pages.aboutus

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.FontSize
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.breakpoints.mutableIsSmallScreen
import web.android.dev.pe.components.widgets.MultiLineText
import web.android.dev.pe.pages.home.components.layouts.AlternateBackground
import web.android.dev.pe.pages.home.components.layouts.HomeSection
import web.android.dev.pe.pages.home.pages.aboutus.sections.LegacyOrganizersSection
import web.android.dev.pe.pages.home.pages.aboutus.sections.OrganizersSection

@Page("/about-us")
@Composable
fun AboutUs() {
    MainSite {
        Div(AboutUsStyle.toAttrs()) {
            Header()
            Intro()
            OrganizersSection()
            LegacyOrganizersSection()
        }
    }
}

@Composable
private fun Header() {
    HomeSection(
        sectionModifier = AlternateBackground,
        modifier = Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .padding(2.em)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.px)
        ) {
            SpanText("🇵🇪", Modifier.fontSize(FontSize.XLarge))
            Image(src = "images/droid.svg", Modifier.size(100.px))
            SpanText("🇵🇪", Modifier.fontSize(FontSize.XLarge))
        }
        P(Modifier.textAlign(TextAlign.Center).fontSize(FontSize.Larger).fontWeight(FontWeight.ExtraBold).toAttrs()) {
            Text("Comunidad de desarolladores Android")
        }
    }
}

@Composable
private fun Intro() {
    val isSmallScreen = mutableIsSmallScreen()
    HomeSection(
        modifier = Modifier.padding(4.em),
    ) {
        SimpleGrid(numColumns = numColumns(base = 1, md = 2), Modifier.alignItems(AlignItems.Center)) {
            if (isSmallScreen) {
                IntroText()
                IntroImage()
            } else {
                IntroImage()
                IntroText()
            }
        }
    }
}

@Composable
private fun IntroImage() {
    Image(src = "images/adp-stock-photo-2.webp", Modifier.fillMaxWidth())
}

@Composable
private fun IntroText() {
   P {
       MultiLineText("""
            Somos la comunidad de Android y Kotlin más grande y activa del Perú. A lo largo de los años,
            hemos organizado decenas de eventos presenciales y virtuales gratuitos.<br><br>
            
            Te invitamos a participar como asistente o expositor en nuestros meetups, workshops, 
            y conferencias. <br><br>
        """.trimIndent())
   }
}

val AboutUsStyle = CssStyle {
    cssRule(" p") {
        Modifier.fontSize(20.px)
    }
}