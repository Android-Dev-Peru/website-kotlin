package web.android.dev.pe.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.border
import com.varabyte.kobweb.silk.theme.colors.palette.color
import com.varabyte.kobweb.silk.theme.colors.palette.link
import kotlinx.browser.localStorage
import org.jetbrains.compose.web.css.px
import web.android.dev.pe.Theme
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.widgets.Language
import web.android.dev.pe.pages.home.Home


const val COLOR_MODE_KEY = "app:colorMode"

@Page
@Composable
fun HomePage() {
    MainSite(lang = Language.Spanish) { Home() }
}

@Page("/en")
@Composable
fun HomePage_EN() {
    MainSite(lang = Language.English) { Home() }
}

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
    ctx.config.initialColorMode = localStorage.getItem(COLOR_MODE_KEY)?.let { ColorMode.valueOf(it) } ?: ColorMode.DARK

    ctx.theme.palettes.light.background = Theme.background.light
    ctx.theme.palettes.light.color = Theme.onBackground.light
    ctx.theme.palettes.light.border = Theme.border.light
    ctx.theme.palettes.light.link.default = Theme.link.light
    ctx.theme.palettes.light.link.visited = Theme.link.light

    ctx.theme.palettes.dark.background = Theme.background.dark
    ctx.theme.palettes.dark.color = Theme.onBackground.dark
    ctx.theme.palettes.dark.border = Theme.border.dark
    ctx.theme.palettes.dark.link.default = Theme.link.dark
    ctx.theme.palettes.dark.link.visited = Theme.link.dark

    ctx.stylesheet.registerStyleBase("body") {
        Modifier
            .fontFamily("Google Sans", "sans-serif")
            .fontSize(16.px)
            .fontWeight(400)
            .margin(0.px)
    }

    ctx.stylesheet.registerStyle("h1") {
        base { Modifier.fontSize(30.px) }
        Breakpoint.MD { Modifier.fontSize(60.px) }
    }

    ctx.stylesheet.registerStyle("h2") {
        base { Modifier.fontSize(40.px) }
    }

    ctx.stylesheet.registerStyle("h3") {
        base { Modifier.fontSize(32.px) }
    }
}
