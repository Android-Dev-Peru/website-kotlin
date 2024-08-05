package web.android.dev.pe.components.widgets.navsite

import androidx.compose.runtime.Composable
import io.github.skeptick.libres.LibresSettings
import kotlinx.browser.document


/**
 * This component is used to set the language of the site.
 * @param lang The language code to set the page to. If null, defaults to "es"
 *             (as configured in the project Kobweb's gradle settings).
 */
@Composable
fun LocalizedSite(navbar: Navbar, lang: String, content: @Composable () -> Unit) {
    /**
     * In a Compose world, this code would typically be considered a bad practice, given that the way that
     * recompositions work, code with side effects within compositions are likely to be executed multiple
     * times, at unpredictable moments.
     *
     * The "safest" way to call this code would be through a LaunchedEffect with a distinct key (could be
     * "lang" in this case). That would ensure the code only runs once. However, the problem with that
     * approach is that it slightly delays the init execution, which causes the string resources to load
     * with the wrong locale. And given its non-mutable nature, it does not recompose.
     *
     * So in this case, we're calling it right away. Given the statically exported nature of this site,
     * seems like it's working as expected and not causing any harmful side effect.
     */
    initLocalization(lang)

    Navsite(navbar, content)
}

private fun initLocalization(lang: String) {
    document.documentElement!!.setAttribute("lang", lang)
    LibresSettings.languageCode = lang
}