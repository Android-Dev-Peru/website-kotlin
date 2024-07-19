package web.android.dev.pe.pages.home

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignItems
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.css.autoLength
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.Res
import web.android.dev.pe.pages.home.sections.HighlightSection
import web.android.dev.pe.pages.home.sections.QuickLinksSection
import web.android.dev.pe.pages.home.sections.TopHeader

@Composable
fun Home() {
    Div(Modifier.fillMaxWidth().toAttrs()) {
        TopHeader()
        QuickLinksSection()
        HighlightSection()
    }
}

val HomeSectionStyle = CssStyle {
    base {
        Modifier
            .maxWidth(1200.px)
            .alignItems(AlignItems.Center)
            .margin(leftRight = autoLength)
    }

    cssRule(" body") {
        Modifier
            .margin(0.px)
            .fontFamily("Google Sans", "sans-serif")
            .fontSize(16.px)
            .fontWeight(400)
    }
    cssRule(" h1") {
        Modifier
            .fontSize(60.px)
    }
    cssRule(" h2") {
        Modifier
            .fontSize(40.px)
            .fontWeight(600)
    }
    cssRule(" h3") {
        Modifier
            .fontSize(32.px)
            .fontWeight(600)
    }
    cssRule(" span") {
        Modifier
            .fontSize(14.px)
            .color(Res.Theme.TEXT.color)
            .textTransform(TextTransform.Uppercase)
    }

}

