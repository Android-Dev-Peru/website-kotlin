package web.android.dev.pe.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextTransform
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import org.jetbrains.compose.web.css.px
import web.android.dev.pe.Res
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

    ctx.stylesheet.registerStyleBase("h1") {
        Modifier
            .fontSize(60.px)
    }

    ctx.stylesheet.registerStyleBase("h2") {
        Modifier
            .fontSize(32.px)
            .fontWeight(600)
    }

    ctx.stylesheet.registerStyleBase("h3") {
        Modifier
            .fontSize(20.px)
            .fontWeight(600)
    }

    ctx.stylesheet.registerStyleBase("span") {
        Modifier
            .fontSize(14.px)
            .color(Res.Theme.TEXT.color)
            .textTransform(TextTransform.Uppercase)
    }
}