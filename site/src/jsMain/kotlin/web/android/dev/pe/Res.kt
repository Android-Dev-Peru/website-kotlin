package web.android.dev.pe

import org.jetbrains.compose.web.css.px

object Res {

    object Links {
        const val Index = "https://androidperu.dev"
        const val Email = "android@devperu.org"
        const val DevTo = "https://dev.to/androiddevperu"
        const val Twitter = "https://twitter.com/androiddevperu"
        const val GitHub = "https://github.com/Android-Dev-Peru"
        const val LinkedIn = "https://www.linkedin.com/company/android-dev-peru"
        const val Instagram = "https://www.instagram.com/androiddevperu/"
        const val YouTube = "https://www.youtube.com/@AndroidDevPeru"
        const val TikTok = "https://www.tiktok.com/@androiddevperu"
        const val WhatsApp = "https://chat.whatsapp.com/Il7yhDYCj8zLVDrK7OpFOm"
        const val TalkProposal = "https://forms.gle/NPKRNKKBP8pryvjT8"
        const val Meetup65 = "https://www.youtube.com/live/zPX-fB-srWw?si=8pRva3vv1uZ5PJ84"
        const val Salarios2023 = "https://android-dev-peru.notion.site/2023-Salarios-Mobile-Devs-40be984176ce4fd099cef15e1c8e17c7"
        const val Salarios2024 = "https://android-dev-peru.notion.site/2024-Salarios-Mobile-Devs-1a49dba648b280a8aaacd6d66c8733bd?pvs=73"
        const val GithubWeb = "https://github.com/Android-Dev-Peru/website-kotlin"

        // Android Conf
        object Conf2024 {
            const val Index = "https://androidperu.dev/conf"
            const val MapUPC = "https://maps.app.goo.gl/WyPeqxmWyJS8bbvJ6"
            const val C4P = "https://www.papercall.io/adpday"
            const val SponsorBrief = "https://docs.google.com/forms/d/e/1FAIpQLSfTA2fmZJyfLi6ssmoGtER-JwWor751g9BDhkrYQ_KjvJaWQw/viewform"
            const val ScheduleMeeting = "https://calendar.google.com/calendar/u/0/appointments/AcZssZ2i6frpcgc1iUvprM_sEyylj2RZqooMBWtA4Gg="
            fun Register(attr: String) = "https://android-dev-peru-conf-2024.eventbrite.com/?aff=$attr"
        }

        object Conf2025 {
            const val Index = "https://androidperu.dev/conf"
            const val C4P = "https://sessionize.com/android-dev-peru-conf-2025/"
            const val SponsorBrief = "https://docs.google.com/forms/d/e/1FAIpQLSfTA2fmZJyfLi6ssmoGtER-JwWor751g9BDhkrYQ_KjvJaWQw/viewform"
            const val ScheduleMeeting = "https://calendar.google.com/calendar/u/0/appointments/AcZssZ2i6frpcgc1iUvprM_sEyylj2RZqooMBWtA4Gg="
            fun Register(attr: String) = "https://android-dev-peru-conf-2025.eventbrite.com/?aff=$attr"
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

    object Dimens {
        val NavbarHeight = 48.px
    }
}