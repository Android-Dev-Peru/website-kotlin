package web.android.dev.pe.components.utils

import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.selectors.after
import org.jetbrains.compose.web.css.*


val CurvyUnderline = CssStyle {
    base {
        Modifier
            .position(Position.Relative)
            .whiteSpace(WhiteSpace.NoWrap)
    }
    after {
        Modifier
            .content("")
            .position(Position.Absolute)
            .left(0.px)
            .right(0.px)
            .bottom(0.3125.em * -0.625)
            .height(0.3125.em)
            .backgroundImage(url("data:image/svg+xml,%3Csvg width='100' height='64' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23a)'%3E%3Cpath d='M-17 30.5C-1 22 72-4 54 13 37.9 28.2-2.5 57.5 16 55.5s72-29 104-40' stroke='%23A5C742' stroke-width='10'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='a'%3E%3Cpath fill='%23fff' d='M0 0h100v64H0z'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A"))
            .backgroundSize(BackgroundSize.of(autoLength, 100.percent))
            .backgroundRepeat(BackgroundRepeat.Round)
            .backgroundPosition(BackgroundPosition.of(CSSPosition(0.em)))
    }
}

