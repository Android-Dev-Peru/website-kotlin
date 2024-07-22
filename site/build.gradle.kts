import com.varabyte.kobweb.gradle.application.extensions.AppBlock.LegacyRouteRedirectStrategy
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.title

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
}

group = "web.android.dev.pe"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
            head.add {
                title("Android Dev Peru 🇵🇪")
                link(rel = "icon", href = "logo.svg", type = "image/svg+xml")
                link(rel = "stylesheet", href = "https://fonts.googleapis.com/css2?family=Google+Sans&display=swap")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")

                // Facebook Meta Tags
                meta(name = "og:url", content = "https://android.devperu.org/conf")
                meta(name = "og:type", content = "website")
                meta(name = "og:title", content = "Android Dev Peru")
                meta(name = "og:description", content = "Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
                meta(name = "og:image", content = "https://android.devperu.org/logo_thumbnail.png")

                // Twitter Meta Tags
                meta(name = "twitter:card", content = "summary_large_image")
                meta(name = "twitter:domain", content = "android.devperu.org")
                meta(name = "twitter:url", content = "https://android.devperu.org/conf")
                meta(name = "twitter:title", content = "Android Dev Peru")
                meta(name = "twitter:description", content = "Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
                meta(name = "twitter:image", content = "https://android.devperu.org/logo_thumbnail.png")
            }
        }

        legacyRouteRedirectStrategy.set(LegacyRouteRedirectStrategy.DISALLOW)
    }
}

kotlin {
    configAsKobwebApplication("pe")

    sourceSets {
        commonMain.dependencies {
            implementation(compose.runtime)
        }

        jsMain.dependencies {
            implementation(compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            
        }
    }
}
