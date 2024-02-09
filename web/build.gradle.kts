plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {

    js {
        browser {
            commonWebpackConfig {
                outputFileName = "kotlin-web.js"
            }
        }
        binaries.executable()
    }
    
    sourceSets {

        val jsMain by getting {
            dependencies {
                implementation(libs.kotlin.stdlib.js)
                implementation(libs.kotlinx.html.js)
            }
        }

        val commonMain by getting {
            dependencies {
                implementation(libs.kotlinx.html)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test")) // Brings all the platform dependencies automatically
            }
        }

        jvm()
    }
}