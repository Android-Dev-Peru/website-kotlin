import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import com.varabyte.kobwebx.gradle.markdown.MarkdownBlock
import com.varabyte.kobwebx.gradle.markdown.MarkdownEntry
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.title

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.libres)
}

group = "web.android.dev.pe"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            description.set("Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
            lang.set("es")
            head.add {
                title("Android Dev Peru 🇵🇪")
                link(rel = "icon", href = "logo.svg", type = "image/svg+xml")
                link(rel = "preconnect", href = "https://fonts.googleapis.com")
                link(rel = "preconnect", href = "https://fonts.gstatic.com", type = "crossorigin")
                link(rel = "stylesheet", href = "https://fonts.googleapis.com/css2?family=Google+Sans&display=swap")
                meta(name = "viewport", content = "width=device-width, initial-scale=1")

                // Facebook Meta Tags
                meta(name = "og:url", content = "https://android.devperu.org")
                meta(name = "og:type", content = "website")
                meta(name = "og:title", content = "Android Dev Peru")
                meta(name = "og:description", content = "Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
                meta(name = "og:image", content = "https://android.devperu.org/thumbnail_es.webp")

                // Twitter Meta Tags
                meta(name = "twitter:card", content = "summary_large_image")
                meta(name = "twitter:domain", content = "androidperu.dev")
                meta(name = "twitter:url", content = "https://androidperu.dev")
                meta(name = "twitter:title", content = "Android Dev Peru")
                meta(name = "twitter:description", content = "Sitio de la comunidad Android Dev Perú. Aquí encontraras eventos, recursos y otras novedades sobre nuestra comunidad de desarrolladores Android.")
                meta(name = "twitter:image", content = "https://androidperu.dev/thumbnail_es.webp")
            }
        }


    }
    markdown {
        defaultRoot.set(".components.layout.MarkdownLayout")

        fun MarkdownBlock.ProcessScope.generateIndex(
            path: String,
            title: String,
            description: String,
            lang: String,
            entries: List<MarkdownEntry>
        ) {
            generateMarkdown("$path/index.md", buildString {
                appendLine(
                    """
                    ---
                    title: $title
                    author: Android Dev Perú
                    description: $description
                    language: $lang
                    ---
                    """.trimIndent()
                )
                appendLine(description)
                entries
                    .filter { it.filePath.startsWith("articles/") }
                    .filter { it.frontMatter["language"]?.first() == lang }
                    .forEach { entry ->
                        val articleTitle = entry.frontMatter["title"]?.firstOrNull() ?: "Untitled"
                        val articleAuthor = entry.frontMatter["author"]?.firstOrNull()?.let { "by $it" } ?: ""
                        appendLine("* \"[$articleTitle](${entry.route})\" $articleAuthor")
                    }
            })
        }

        process.set { markdownEntries ->
            generateIndex(
                path = "articles",
                title = "Artículos",
                description = "Artículos escritos por y para la comunidad.",
                lang = "es",
                entries = markdownEntries
            )
            generateIndex(
                path = "articles/en",
                title = "Articles",
                description = "Articles written by and for the community.",
                lang = "en",
                entries = markdownEntries
            )
        }
    }
}

kotlin {
    configAsKobwebApplication("pe")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kobwebx.markdown)
            implementation(libs.libres)
        }
    }

    targets.configureEach {
        compilations.configureEach {
            compileTaskProvider.get().compilerOptions {
                freeCompilerArgs.add("-Xexpect-actual-classes")
            }
        }
    }

    /**
     * TODO:
     * Enable ES2015 support, available since Kotlin 2.0 and Kobweb 0.19.23 in the future.
     * Add the moment, the build is failing at compile time with the following error:
     * https://gist.github.com/Bruno125/1d34d5021c23fa6fc4fd6549c0df35d2
     */
    // js {
    //     @OptIn(ExperimentalKotlinGradlePluginApi::class)
    //     compilerOptions.target = "es2015"
    // }
}

// Multiplatform lib to handle localized texts
libres {
    // https://github.com/Skeptick/libres#setup
    generatedClassName = "Res"
    generateNamedArguments = true
    baseLocaleLanguageCode = "es"
}