package web.android.dev.pe.pages.conf.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.selectors.hover
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Theme
import web.android.dev.pe.components.widgets.DecoratedHeading
import web.android.dev.pe.components.widgets.MultiLineText
import web.android.dev.pe.data.Presentation
import web.android.dev.pe.get
import web.android.dev.pe.pages.conf.components.layouts.ConferenceGridSection
import web.android.dev.pe.pages.conf.components.widgets.TalkDialog
import web.android.dev.pe.pages.home.components.layouts.SocialIcons

@Composable
fun SpeakersSection(talks: List<Presentation>) {
    val selectedPresentation = remember { mutableStateOf<Presentation?>(null) }
    ConferenceGridSection(
        header = {
            DecoratedHeading(ResStrings.conf_speakers_title, "speakers")
            P { Text(ResStrings.conf_speakers_caption) }
        },
        content = {
            SimpleGrid(numColumns(1, md = 2, lg = 3), Modifier.margin(2.em)) {
                talks.forEach { presentation ->
                    Speaker(presentation, onSelected = {
                        selectedPresentation.value = it
                    })
                }
            }
        },
        contentModifier = Modifier.flex(3)
    )
    TalkDialog(selectedPresentation)
}

@Composable
private fun Speaker(
    presentation: Presentation,
    onSelected: (presentation: Presentation) -> Unit
) {
    val clickModifier = Modifier.onClick { onSelected(presentation) }
    Div(SpeakersSectionStyles.speakerCard.toModifier().then(clickModifier).toAttrs()) {
        SpeakerImage(presentation)
        Div(Modifier.padding(leftRight = 1.em).toAttrs()) {
            P(SpeakersSectionStyles.speakerTitle.toAttrs()) {
                Text(presentation.speakerName)
            }
            P(Modifier.margin(0.px).fontSize(FontSize.XSmall).fillMaxWidth().toAttrs()) {
                MultiLineText(presentation.speakerRole)
            }
            P(Modifier.fontSize(FontSize.Medium).fillMaxWidth().toAttrs()) {
                Text(presentation.title)
            }
            SocialIcons(presentation.socials, Modifier.justifyContent(JustifyContent.Center))
        }
    }
}

@Composable
private fun SpeakerImage(presentation: Presentation) {
    Box {
        Image(
            src = presentation.speakerPhotoRegular,
            alt = presentation.speakerName,
            modifier = Modifier.fillMaxWidth(),
        )
        Box(SpeakersSectionStyles.speakerImageHover.toModifier()) {
            Image(
                src = presentation.speakerPhotoHover,
                alt = presentation.speakerName,
                modifier = Modifier.fillMaxWidth(),
            )
            P(SpeakersSectionStyles.viewMore.toAttrs()) {
                Text(ResStrings.conf_speaker_details)
            }
        }
    }
}

private val Presentation.speakerPhotoRegular
    get() = "$speakerPhoto-circular-empty.webp"

private val Presentation.speakerPhotoHover
    get() = "$speakerPhoto-bw.webp"

object SpeakersSectionStyles {
    val speakerTitle = CssStyle {
        base {
            Modifier
                .fontSize(FontSize.XLarge)
                .fontWeight(FontWeight.Bold)
                .backgroundColor(colorMode.get(Theme.surface))
                .padding(leftRight = 8.px, topBottom = 4.px)
        }
    }
    val speakerCard = CssStyle {
        base {
            Modifier
                .borderRadius(24.px)
                .textAlign(TextAlign.Center)
                .overflow(Overflow.Clip)
                .margin(topBottom = 2.em)
        }

        Breakpoint.MD {
            Modifier.margin(topBottom = 2.em, leftRight = 1.em)
        }
    }

    val speakerImageHover = CssStyle {
        base {
            Modifier.fillMaxWidth().display(DisplayStyle.None)
        }

        Breakpoint.MD {
            Modifier.display(DisplayStyle.Inherit).opacity(0)
        }

        hover {
            Modifier.opacity(100).cursor(Cursor.Pointer)
        }
    }
    val viewMore = CssStyle {
        base {
            Modifier
                .fontSize(FontSize.XLarge)
                .fontWeight(FontWeight.Bold)
                .color(Color.white)
                .backgroundColor(Theme.DARK_GREEN)
                .padding(leftRight = 8.px, topBottom = 4.px)
                .alignSelf(AlignSelf.End)
        }
    }
}
