package web.android.dev.pe.pages.home.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun HomeGridSection(
    sectionModifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    val styles = GridSectionStyles
    HomeSection(
        modifier = styles.container.toModifier(),
        sectionModifier = sectionModifier,
    ) {
        Div(styles.header.toAttrs()) {
            header()
        }
        Div(styles.content.toAttrs()) {
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
            Modifier.flex(1).margin(bottom = 2.em)
        }
        Breakpoint.MD {
            Modifier.margin(0.px)
        }
    }

    val content = CssStyle {
        base {
            Modifier
                .flex(2)
                .flexDirection(FlexDirection.Column)
                .padding(0.px)
                .gap(2.em)
        }
        Breakpoint.MD {
            Modifier
                .padding(leftRight = 2.em, bottom = 2.em)
                .flexDirection(FlexDirection.Row)
                .display(DisplayStyle.Grid)
                .gridTemplateColumns {
                    size(1.fr)
                    size(1.fr)
                }
        }
    }
}

