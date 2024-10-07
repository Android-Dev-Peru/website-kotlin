package web.android.dev.pe.pages.conf.components.widgets

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.AlignSelf
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaXmark
import com.varabyte.kobweb.silk.components.icons.fa.IconSize
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.JustifyContent.Companion.Unset
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import web.android.dev.pe.Res
import web.android.dev.pe.components.widgets.*
import web.android.dev.pe.data.Presentation
import web.android.dev.pe.pages.home.components.layouts.SocialIcons


@Composable
fun TalkDialog(presentation: MutableState<Presentation?>) {
    Dialog(
        showModal = presentation.value != null,
        onClose = { presentation.value = null },
        modifier = TalkDialogStyles.dialog.toModifier(),
    ) {
        presentation.value?.let {
            Column {
                DefaultDialogHeading(onClick = { presentation.value = null })
                Content(it)
            }
        }
    }
}

@Composable
private fun Content(presentation: Presentation) {
    Div(TalkDialogStyles.container.toAttrs()) {
        Column(TalkDialogStyles.speakerContainer.toModifier()) {
            Image(
                src = presentation.speakerPhotoFull,
                alt = presentation.speakerName,
                modifier = TalkDialogStyles.speakerImage.toModifier(),
            )
            P(TalkDialogStyles.speakerInfo.toAttrs()) {
                SpanText(presentation.speakerName, Modifier
                    .fontSize(FontSize.XLarge)
                    .fontWeight(FontWeight.Bold))
                Br()
                MultiLineText(presentation.speakerRole, Modifier.fontSize(FontSize.Small))
            }
            SocialIcons(presentation.socials, Modifier.justifyContent(JustifyContent.Center))
        }
        Column(TalkDialogStyles.talkDescription.toModifier()) {
            P(TalkDialogStyles.talkTitle.toAttrs()) {
                HeadingDecorator()
                SpanText(presentation.title)
            }
            P(Modifier.fontSize(FontSize.Small).toAttrs()) {
                MultiLineText(presentation.description)
            }
            PrimaryButton(
                text = "¿Te interesa? Regístrate",
                href = Res.Links.Conf.Register("webspeaker"),
                modifier = Modifier.margin(topBottom = 16.px),
                variant = RectangularPrimaryButtonVariant,
            )
        }
    }
}


private val Presentation.speakerPhotoFull
    get() = "$speakerPhoto.webp"

object TalkDialogStyles {
    val dialog = CssStyle {
        base {
            Modifier.maxWidth(800.px).padding(1.em).overflow(Overflow.Hidden).margin(2.em)
        }
        Breakpoint.MD {
            Modifier.padding(2.em)
        }
    }
    val container = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .overflow(Overflow.Scroll)
                .height(60.vh) // needed so that the content can scroll
        }
        Breakpoint.MD {
            Modifier
                .flexDirection(FlexDirection.Row)
                .overflow(Overflow.Unset)
                .height(Height.Unset)
        }
    }
    val speakerContainer = CssStyle {
        base {
            Modifier.justifyContent(JustifyContent.Center)
        }
        Breakpoint.MD {
            Modifier.justifyContent(Unset)
        }
    }
    val speakerImage = CssStyle {
        base {
            Modifier.size(250.px).alignSelf(AlignSelf.Center)
        }
        Breakpoint.MD {
            Modifier.alignSelf(AlignSelf.Unset)
        }
    }
    val speakerInfo = CssStyle {
        base {
            Modifier.textAlign(TextAlign.Center).alignSelf(AlignSelf.Center)
        }
    }
    val talkTitle = CssStyle {
        base {
            Modifier.fontSize(FontSize.XLarge)
        }
        Breakpoint.MD {
            Modifier.margin(top = 0.px)
        }
    }

    val talkDescription = CssStyle {
        Breakpoint.MD {
            Modifier.padding(leftRight = 2.em)
        }
    }
}
