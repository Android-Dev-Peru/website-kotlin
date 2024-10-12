package web.android.dev.pe

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.graphics.lightened
import com.varabyte.kobweb.silk.theme.colors.ColorMode

object Theme {
    val DARK_GREEN = Color.rgb(56, 118, 29)
    val LIGHT_GREEN = Color.rgb(166, 199, 66)
    val LIGHT_BLUE = Color.rgb(174, 203, 250)
    val GRAY = Color.rgb(230, 230, 230)

    data class ThemeColor(
        val light: Color,
        val dark: Color = light
    )

    val primary = ThemeColor(
        light = Colors.Black,
        dark = DARK_GREEN,
    )
    val secondary = ThemeColor(
        light = GRAY,
        dark = LIGHT_GREEN,
    )
    val background = ThemeColor(
        light = Colors.White,
        dark = Colors.Black,
    )
    val surface = ThemeColor(
        light = Color.rgb(248, 249, 250),
        dark = Color.rgb(32, 33, 36),
    )
    val onPrimary = ThemeColor(
        light = Colors.White,
        dark = Colors.White,
    )
    val onSecondary = ThemeColor(
        light = Colors.Black,
        dark = Colors.Black,
    )
    val onBackground = ThemeColor(
        light = Color.rgb(60, 64, 67),
        dark = Color.rgb(220, 220, 220),
    )
    val onSurface = ThemeColor(
        light = Colors.Black,
        dark = Colors.White,
    )
    val onBackgroundSoft = ThemeColor(
        light = onBackground.light.lightened(0.2f),
        dark = onBackground.dark.darkened(0.2f),
    )
    val border = ThemeColor(
        light = Color.rgb(218, 220, 224),
        dark = Color.rgb(128, 134, 139),
    )
    val shadow = ThemeColor(
        light = Color.rgba(0, 0, 0, 0.1f),
        dark = Color.rgba(255, 255, 255, 0.2f),
    )
    val link = ThemeColor(
        light = DARK_GREEN,
        dark = LIGHT_BLUE,
    )
    val navbar = ThemeColor(
        light = background.light,
        dark = surface.dark,
    )
    val navbarBorder = ThemeColor(
        light = border.light,
        dark = border.dark.darkened(0.5f),
    )
    val navmask = ThemeColor(
        light = Color.rgba(0, 0, 0, 0.4f),
        dark = Color.rgba(0, 0, 0, 0.6f),
    )
    val tableHeader = ThemeColor(
        light = Color.rgb(240,240,240),
        dark = Color.rgb(50,50,50),
    )
}

fun ColorMode.get(color: Theme.ThemeColor) = when (this) {
    ColorMode.LIGHT -> color.light
    ColorMode.DARK -> color.dark
}

@Composable
fun String.colorAwareSVG(): String {
    val colorMode by ColorMode.currentState
    return when(colorMode) {
        ColorMode.LIGHT -> this
        ColorMode.DARK -> this.replace(".svg", "_white.svg")
    }
}
