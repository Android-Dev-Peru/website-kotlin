package web.android.dev.pe.components.widgets

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.filter
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.px

@Composable
fun BlurredBackground(modifier: Modifier = Modifier) {
    Box(modifier.then(BlurredBackgroundStyle.toModifier()))
}

val BlurredBackgroundStyle = CssStyle.base {
    Modifier
        .background(
            Background.of(
                image = BackgroundImage.of(url("../../images/android-header.jpeg")),
                repeat = BackgroundRepeat.NoRepeat,
                position = BackgroundPosition.of(CSSPosition.Center),
                size = BackgroundSize.Cover
            )
        ).filter(blur(1.px))

}