package web.android.dev.pe.pages.conf.year_2025.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun ConferenceGridSection(
    modifier: Modifier = Modifier,
    sectionModifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    val styles = ConferenceGridSectionStyles
    ConferenceSection(
        sectionModifier = sectionModifier,
        modifier = ConferenceGridSectionStyles.container.toModifier().then(modifier)
    ) {
        Div(ConferenceGridSectionStyles.header.toAttrs()) {
            header()
        }
        Div(ConferenceGridSectionStyles.content.toModifier().then(contentModifier).toAttrs()) {
            content()
        }
    }
}

object ConferenceGridSectionStyles {
    /**
     * align-items passed as extraModifier because otherwise it would override
     * the home-section value. The only way to enforce it is bypassing it as a
     * style param at the tag level.
     */
    val container = CssStyle(extraModifier = Modifier.alignItems(AlignItems.FlexStart)) {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .fillMaxWidth()
                .flexDirection(FlexDirection.Column)
        }

        Breakpoint.MD {
            Modifier.flexDirection(FlexDirection.Row)
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
                .flex(1)
                .flexDirection(FlexDirection.Column)
                .padding(0.px)
                .gap(2.em)
        }
        Breakpoint.MD {
            Modifier
                .padding(leftRight = 2.em, bottom = 2.em)
                .flexDirection(FlexDirection.Row)
        }
    }
}

