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
import org.jetbrains.compose.web.css.px
import web.android.dev.pe.pages.home.Home

@Page
@Composable
fun HomePage() {
    Home()
}

@InitSilk
fun initSiteStyles(ctx: InitSilkContext) {
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
