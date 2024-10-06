package web.android.dev.pe.components.layout

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.css.CSSFloat
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobwebx.markdown.markdown
import kotlinx.browser.document
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import strings.ResStrings
import web.android.dev.pe.Theme
import web.android.dev.pe.components.MainSite
import web.android.dev.pe.components.utils.MetaTag
import web.android.dev.pe.components.utils.modifyMetaTag
import web.android.dev.pe.components.widgets.Language

@Composable
fun MarkdownLayout(content: @Composable () -> Unit) {
    val ctx = rememberPageContext()
    val title = ctx.markdown!!.frontMatter.getValue("title").single()
    val description = ctx.markdown!!.frontMatter.getValue("description").single()
    val language = ctx.markdown!!.frontMatter.getValue("language").single()
    val lang = when (language) {
        "en" -> Language.English
        else -> Language.Spanish
    }
    MainSite(lang) {
        Div(MarkdownContainer.toAttrs()) {
            H1 { Text(title) }
            content()
        }
    }
    LaunchedEffect(lang) {
        setupTags(lang, title, description)
    }
}

private fun setupTags(lang: Language,  title: String, description: String) {
    val siteTitle = "$title - Android Dev Peru"
    document.title = siteTitle
    modifyMetaTag(MetaTag.TITLE, siteTitle)
    modifyMetaTag(MetaTag.OG_TITLE, siteTitle)
    modifyMetaTag(MetaTag.TWITTER_TITLE, siteTitle)

    modifyMetaTag(MetaTag.DESCRIPTION, description)
    modifyMetaTag(MetaTag.OG_DESCRIPTION, description)
    modifyMetaTag(MetaTag.TWITTER_DESCRIPTION, description)

    modifyMetaTag(MetaTag.OG_LOCALE, lang.locale)
}

val MarkdownContainer = CssStyle {
    base {
        Modifier.padding(2.em).fontSize(18.px).lineHeight(1.5)
    }
    Breakpoint.MD {
        Modifier.padding(leftRight = 8.em, topBottom = 2.em).fontSize(20.px)
    }

    cssRule(" h2") {
        Modifier.margin(top = 1.em, bottom = 0.em)
    }

    cssRule("ul") {
        Modifier.padding(leftRight = 1.em)
    }

    cssRule(" h2:before") {
        Modifier.content("▮\\00a0").color(Theme.LIGHT_GREEN).float(CSSFloat.Left)
    }
}