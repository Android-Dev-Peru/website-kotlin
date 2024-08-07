package web.android.dev.pe

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgb

object Res {

    object Links {
        const val Email = "android@devperu.org"
        const val DevTo = "https://dev.to/androiddevperu"
        const val Twitter = "https://twitter.com/androiddevperu"
        const val GitHub = "https://github.com/Android-Dev-Peru"
        const val LinkedIn = "https://www.linkedin.com/company/android-dev-peru"
        const val Instagram = "https://www.instagram.com/androiddevperu/"
        const val YouTube = "https://www.youtube.com/@AndroidDevPeru"
        const val TikTok = "https://www.tiktok.com/@androiddevperu"
        const val WhatsApp = "https://chat.whatsapp.com/Il7yhDYCj8zLVDrK7OpFOm"
        const val TalkProposal = "https://github.com/Android-Dev-Peru/propuestas-meetup/issues/new?assignees=&labels=&projects=&template=plantilla-de-propuesta.md&title=Charla%3A+T%C3%ADtulo+de+la+charla"
        const val KotlinConf2024 = "https://www.youtube.com/live/yB5UiuIBZsY?si=8Tltr1OWZCYATVBB"
        const val Salarios2023 = "https://android-dev-peru.notion.site/2023-Salarios-Mobile-Devs-40be984176ce4fd099cef15e1c8e17c7"
        const val GithubWeb = "https://github.com/Android-Dev-Peru/website-kotlin"

        // Android Conf
        object Conf {
            const val MapUPC = "https://maps.app.goo.gl/WyPeqxmWyJS8bbvJ6"
            const val C4P = "https://www.papercall.io/adpday"
            const val SponsorBrief = "https://docs.google.com/forms/d/e/1FAIpQLSfTA2fmZJyfLi6ssmoGtER-JwWor751g9BDhkrYQ_KjvJaWQw/viewform"
            const val Register = ""
            const val ScheduleMeeting = "https://calendar.google.com/calendar/u/0/appointments/AcZssZ2i6frpcgc1iUvprM_sEyylj2RZqooMBWtA4Gg="
        }

    }

    object Icon {
        val Whatsapp = "/icons/social_wsp.svg"
        val YouTube = "/icons/social_youtube.svg"
        val Twitter = "/icons/social_twitter.svg"
        val Instagram = "/icons/social_instagram.svg"
        val LinkedIn = "/icons/social_linkedin.svg"
        val GitHub = "/icons/social_github.svg"
        val TikTok = "/icons/social_tiktok.svg"
        val WhatsappFilled = "/icons/social_wsp_filled.svg"
        val LinkedinFilled = "/icons/social_linkedin_filled.svg"
        val Speaker = "/icons/icon_speaker.png"
        val ExternalLink = "/icons/icon_external_link.svg"
    }

    enum class Theme(val color: CSSColorValue) {
        PRIMARY(color = rgb(56, 118, 29)),
        PRIMARY_LIGHT(color = rgb(166, 199, 66)),
        TEXT(color = rgb(95, 99, 104)),
        LIGHT_TEXT(color = rgb(23, 78, 166)),
        ALTERNATE_BACKGROUND(color = rgb(248, 249, 250)),
        BORDER(color = rgb(218, 220, 224)),

        PRIMARY_BUTTON(color = Color.black),
        ON_PRIMARY_BUTTON(color = Color.white),

        BUTTON_HOVER(color = rgb(230, 230, 230)),
        LINK(color = rgb(23, 78, 166)),
        SHADOW(color = rgb(60, 64, 67)),
        BLACK(color = Color.black),
        WHITE(color = Color.white),
    }

    object Dimens {
        val NavbarHeight = 48.px
    }
}