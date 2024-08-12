package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.icons.fa.FaMoon
import com.varabyte.kobweb.silk.components.icons.fa.FaSun
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.AlignContent
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import web.android.dev.pe.Theme
import web.android.dev.pe.get

@Composable
fun ThemeSwitcher(modifier: Modifier = Modifier) {
    var colorMode by ColorMode.currentState
    val iconModifier = ThemeSwitcherStyle
        .toModifier()
        .onClick { colorMode = colorMode.opposite }
        .then(modifier)

    when(colorMode){
        ColorMode.LIGHT -> FaSun(iconModifier)
        ColorMode.DARK -> FaMoon(iconModifier)
    }
}

val ThemeSwitcherStyle = CssStyle {
    base {
        Modifier
            .size(36.px)
            .textAlign(TextAlign.Center)
            .alignSelf(AlignSelf.Center)
            .alignContent(AlignContent.Center)
            .cursor(Cursor.Pointer)
    }
    hover {
        Modifier
            .background(colorMode.get(Theme.shadow))
            .borderRadius(50.percent)
    }
}
