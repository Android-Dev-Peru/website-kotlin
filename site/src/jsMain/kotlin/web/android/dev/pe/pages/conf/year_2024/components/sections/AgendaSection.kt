package web.android.dev.pe.pages.conf.year_2024.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.dom.*
import strings.ResStrings
import web.android.dev.pe.Theme
import web.android.dev.pe.components.widgets.HeadingDecorator
import web.android.dev.pe.data.Presentation
import web.android.dev.pe.get
import web.android.dev.pe.pages.conf.year_2024.components.layouts.ConferenceSection
import web.android.dev.pe.pages.conf.year_2024.components.widgets.TalkDialog

sealed class AgendaEntry(
    val title: String,
    val time: String,
    val description: String,
) {
    class Talk(val presentation: Presentation, time: String) : AgendaEntry(
        title = presentation.title,
        time = time,
        description = presentation.speakerName,
    )
    class Other(title: String, time: String, description: String) : AgendaEntry(
        title = title,
        time = time,
        description = description,
    )
}

@Composable
fun AgendaSection(entries: List<AgendaEntry>, sectionModifier: Modifier = Modifier) {
    ConferenceSection(sectionModifier = sectionModifier, modifier = Modifier.fillMaxWidth()) {
        Div(AgendaStyles2024.card.toAttrs()) {
            H2(AgendaStyles2024.heading.toAttrs()) { Text(ResStrings.conf_agenda_title) }
            AgendaEntries(entries)
        }
    }
}

@Composable
private fun AgendaEntries(list: List<AgendaEntry>) {
    val selectedPresentation = remember { mutableStateOf<Presentation?>(null) }
    Ol(AgendaStyles2024.entries.toAttrs()) {
        list.forEach {
            AgendaEntryRow(it, onSelected = {
                selectedPresentation.value = it
            })
        }
    }
    TalkDialog(selectedPresentation)
}

@Composable
private fun AgendaEntryRow(entry: AgendaEntry, onSelected: (presentation: Presentation) -> Unit) {
    HorizontalDivider(AgendaStyles2024.entryDivider.toModifier())
    Li(AgendaStyles2024.entry.toAttrs()) {
        Div(AgendaStyles2024.entryTime.toAttrs()) {
            HeadingDecorator(when(entry) {
                is AgendaEntry.Talk -> Theme.LIGHT_GREEN
                is AgendaEntry.Other -> Theme.LIGHT_BLUE
            })
            SpanText(entry.time)
        }
        Div(AgendaStyles2024.entryTitle.toAttrs()) {
            when(entry) {
                is AgendaEntry.Talk -> {
                    Link(
                        path = "",
                        modifier = Modifier
                            .onClick { onSelected(entry.presentation) }
                            .cursor(Cursor.Pointer)
                    ) {
                        SpanText(entry.title, Modifier.fontWeight(FontWeight.Bolder))
                    }
                }
                is AgendaEntry.Other -> {
                    SpanText(entry.title)
                }
            }
        }
        Div(AgendaStyles2024.entryDescription.toAttrs()) {
            SpanText(entry.description)
        }
    }
}

object AgendaStyles2024 {
    val card = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .fillMaxWidth()
                .backgroundColor(colorMode.get(Theme.background))
                .borderRadius(24.px)
                .padding(16.px)
                .border {
                    width(1.px)
                    style(LineStyle.Solid)
                    color(colorMode.get(Theme.border))
                }
                .margin(bottom = 4.em)
        }
        Breakpoint.MD {
            Modifier.padding(32.px)
        }
    }
    val heading = CssStyle {
        base {
            Modifier
                .textAlign(TextAlign.Center)
                .margin(topBottom = 0.px)
        }
        Breakpoint.MD {
            Modifier.textAlign(TextAlign.Unset)
        }
    }
    val entries = CssStyle {
        base {
            Modifier
                .listStyle(ListStyleType.None)
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .alignItems(AlignItems.Center)
                .padding(8.px)
        }
    }
    val entry = CssStyle {
        base {
            Modifier
                .display(DisplayStyle.Flex)
                .flexDirection(FlexDirection.Column)
                .fillMaxWidth()
                .gap(8.px)
        }
        Breakpoint.MD {
            Modifier
                .display(DisplayStyle.Flex)
                .alignItems(AlignItems.Center)
                .flexDirection(FlexDirection.Row)
                .margin(topBottom = 1.em)
        }

        cssRule("span") {
            Modifier.textAlign(TextAlign.Start)
        }
    }

    val entryTime = CssStyle {
        base {
            Modifier
                .flex(1)
                .fontSize(FontSize.Small)
                .color(colorMode.get(Theme.onBackgroundSoft))
        }
        Breakpoint.MD {
            Modifier.fontSize(FontSize.Inherit)
        }
    }

    val entryTitle = CssStyle {
        base {
            Modifier
                .flex(2)
                .color(colorMode.get(Theme.onBackground))
        }
    }

    val entryDescription = CssStyle {
        base {
            Modifier
                .flex(1)
                .fontSize(FontSize.Small)
                .color(colorMode.get(Theme.onBackgroundSoft))
        }
        Breakpoint.MD {
            Modifier.fontSize(FontSize.Inherit)
        }
    }

    val entryDivider = CssStyle {
        base {
            Modifier
                .border { color(colorMode.get(Theme.border)) }
                .margin(8.px)
        }
    }
}