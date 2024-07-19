import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
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
//                link(rel = "stylesheet", href = "styles.css")
                link(rel = "stylesheet", href = "https://fonts.googleapis.com/css2?family=Google+Sans&display=swap")
//              TODO: meta(name = "viewport", content = "width=device-width, initial-scale=1")
            }
        }
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
