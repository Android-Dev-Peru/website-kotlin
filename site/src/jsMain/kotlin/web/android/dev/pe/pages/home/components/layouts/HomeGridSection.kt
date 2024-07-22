package web.android.dev.pe.pages.home.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun TwoPaneSection(
    modifier: Modifier = Modifier,
    sectionModifier: Modifier = Modifier,
    distribution: Pair<Int, Int> = Pair(1,2),
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    val styles = GridSectionStyles
    HomeSection(
        modifier = styles.container.toModifier().then(modifier),
        sectionModifier = sectionModifier,
    ) {
        Div(styles.header.toModifier().flex(distribution.first).toAttrs()) {
            header()
        }
        Div(styles.content.toModifier().flex(distribution.second).toAttrs()) {
            content()
        }
    }
}

object GridSectionStyles {
    /**
     * align-items passed as extraModifier because otherwise it would override
     * the home-section value. The only way to enforce it is bypassing it as a
     * style param at the tag level.
     */
    val container = CssStyle(extraModifier = Modifier.alignItems(AlignItems.FlexStart)) {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .padding(2.em)
        }

        Breakpoint.MD {
            Modifier
                .flexDirection(FlexDirection.Row)
                .padding(top = 4.em, bottom = 0.px, leftRight = 0.px)
        }
    }

    val header = CssStyle {
        base {
            Modifier.margin(bottom = 2.em)
        }
        Breakpoint.MD {
            Modifier.margin(0.px)
        }
    }

    val content = CssStyle {
        base {
            Modifier
                .fillMaxWidth()
                .flexDirection(FlexDirection.Column)
                .padding(0.px)
        }
        Breakpoint.MD {
            Modifier
                .padding(leftRight = 2.em, bottom = 2.em)
                .flexDirection(FlexDirection.Row)
        }
    }
}

