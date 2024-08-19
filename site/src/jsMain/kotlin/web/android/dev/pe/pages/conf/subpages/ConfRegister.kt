package web.android.dev.pe.pages.conf.subpages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Routes
import web.android.dev.pe.Theme
import web.android.dev.pe.components.ConferenceNavbar
import web.android.dev.pe.components.ConferenceSite
import web.android.dev.pe.components.utils.appendCurrentLanguage
import web.android.dev.pe.components.widgets.ConvertKitForm
import web.android.dev.pe.get

/**
 * Hiding the primary action because in this page, the "Register" button
 * from the form should be the primary CTA.
 */
private val CustomNavbar = ConferenceNavbar.copy(primaryLink = null)

@Page("/conf/register")
@Composable
fun ConfRegister() {
    ConferenceSite(lang = "es", navbar = CustomNavbar) {
        Content(formUid = "38d329d2c2")
    }
}

@Page("/conf/register/en")
@Composable
fun ConfRegister_EN() {
    ConferenceSite(lang = "en", navbar = CustomNavbar) {
        Content(formUid = "06248e81fd")
    }
}

@Composable
private fun Content(formUid: String) {
    Div(ConferenceRegisterStyle.toAttrs()) {
        Instructions()
        ConvertKitForm(formUid)
    }
}

@Composable
private fun Instructions() {
    Div(ConferenceRegisterHintStyle.toAttrs()) {
        Text(ResStrings.conf_register_instructions_pt1)
        P {
            Text(ResStrings.conf_register_accept_code_of_conduct_pt1)
            Link(
                path = Routes.Conf.CodeOfConduct.appendCurrentLanguage(),
                openInternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
            ) {
                Text(ResStrings.conf_register_accept_code_of_conduct_pt2)
            }
            Text(ResStrings.conf_register_accept_code_of_conduct_pt3)
            Link(
                path = Routes.PrivacyPolicy.appendCurrentLanguage(),
                openInternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
            ) {
                Text(ResStrings.conf_register_accept_code_of_conduct_pt4)
            }
        }
    }
}

val ConferenceRegisterStyle = CssStyle {
    base {
        Modifier
            .padding(1.em)
            .backgroundColor(colorMode.get(Theme.surface))
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
    }
    Breakpoint.MD {
        Modifier.padding(2.em)
    }
}

val ConferenceRegisterHintStyle = CssStyle.base {
    Modifier.maxWidth(700.px).alignSelf(AlignSelf.Center).textAlign(TextAlign.Center)
}
