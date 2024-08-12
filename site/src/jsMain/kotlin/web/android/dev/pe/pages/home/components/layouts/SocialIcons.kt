package web.android.dev.pe.pages.home.components.layouts

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.ariaLabel
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.dom.Div
import web.android.dev.pe.colorAwareSVG
import web.android.dev.pe.data.Social
import web.android.dev.pe.data.Socials
import web.android.dev.pe.pages.home.components.sections.HomeHeaderStyles

@Composable
fun SocialIcons(modifier: Modifier = Modifier) {
    Div (HomeHeaderStyles.SocialMediaRow.toModifier().then(modifier).toAttrs()) {
        Socials.entries.forEach {
            SocialIcon(it.data)
        }
    }
}

@Composable
fun SocialIcon(social: Social) {
    Link(path = social.url, modifier = Modifier.ariaLabel(social.name)) {
        Image(src = social.icon.colorAwareSVG(), modifier = HomeHeaderStyles.SocialMediaIcon.toModifier())
    }
}
