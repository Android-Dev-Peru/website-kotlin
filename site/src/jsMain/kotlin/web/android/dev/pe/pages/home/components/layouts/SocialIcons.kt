package web.android.dev.pe.pages.home.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.JustifyContent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.colorAwareSVG
import web.android.dev.pe.data.Social
import web.android.dev.pe.pages.home.components.sections.HomeHeaderStyles

@Composable
fun SocialIcons(socials: List<Social>, modifier: Modifier = Modifier) {
    Div (SocialMediaRow.toModifier().then(modifier).toAttrs()) {
        socials.forEach {
            SocialIcon(it)
        }
    }
}

@Composable
fun SocialIcon(social: Social) {
    Link(path = social.url, modifier = Modifier.ariaLabel(social.name)) {
        Image(src = social.icon.colorAwareSVG(), modifier = HomeHeaderStyles.SocialMediaIcon.toModifier())
    }
}

val SocialMediaRow = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
            .flexWrap(FlexWrap.Wrap)
            .gap(4.px)
            .justifyContent(JustifyContent.Center)
    }
    Breakpoint.MD {
        Modifier.justifyContent(JustifyContent.Start).gap(8.px)
    }
}