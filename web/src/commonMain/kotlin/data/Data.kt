package data

import components.QuickLink
import home.BlogEntry
import home.Organizer
import home.Playlist
import home.Social

object Links {
    const val DevTo = "https://dev.to/androiddevperu"
    const val Twitter = "https://twitter.com/androiddevperu"
    const val GitHub = "https://github.com/Android-Dev-Peru"
    const val LinkedIn = "https://www.linkedin.com/company/android-dev-peru"
    const val Instagram = "https://www.instagram.com/androiddevperu/"
    const val YouTube = "https://www.youtube.com/@AndroidDevPeru"
    const val TikTok = "https://www.tiktok.com/@androiddevperu"
    const val WhatsApp = "https://chat.whatsapp.com/Il7yhDYCj8zLVDrK7OpFOm"
}

enum class Socials(val data: Social) {
    SocialWhatsApp(Social(icon = "social_wsp.svg", url = Links.WhatsApp)),
    SocialYouTube(Social(icon = "social_youtube.svg", url = Links.YouTube)),
    SocialTwitter(Social(icon = "social_twitter.svg", url = Links.Twitter)),
    SocialInstagram(Social(icon = "social_instagram.svg", url = Links.Instagram)),
    SocialLinkedIn(Social(icon = "social_linkedin.svg", url = Links.LinkedIn)),
    SocialGitHub(Social(icon = "social_github.svg", url = Links.GitHub)),
    SocialTikTok(Social(icon = "social_tiktok.svg", url = Links.TikTok)),
}

enum class QuickLinks(val data: QuickLink) {
    JoinWhatsApp(
        QuickLink(
            title = "Únete en WhatsApp",
            url = Links.WhatsApp,
            leftIcon = "social_wsp_filled.svg",
            rightIcon = "icon_external_link.svg",
        )
    ),
    GiveATalk(
        QuickLink(
            title = "Da una charla",
            url = "https://github.com/Android-Dev-Peru/propuestas-meetup/issues/new?assignees=&labels=&projects=&template=plantilla-de-propuesta.md&title=Charla%3A+T%C3%ADtulo+de+la+charla",
            leftIcon = "icon_speaker.png",
            rightIcon = "icon_external_link.svg",
        )
    ),
    FollowLinkedIn(
        QuickLink(
            title = "Síguenos en LinkedIn",
            url = Links.LinkedIn,
            leftIcon = "social_linkedin_filled.svg",
            rightIcon = "icon_external_link.svg",
        )
    ),
}

enum class Playlists(val data: Playlist) {
    Meetups(
        Playlist(
            title = "[LIVE] Meetups",
            url = "https://youtube.com/playlist?list=PLdIqyKXhJsgTtpZz6boXclEcuPYb-rupb&si=_efDqZYdPrGU9lTQ",
            thumbnail = "images/thumbnail_meetup.webp",
            description = "Revisa las grabaciones de nuestros meetups pasados.",
        )
    ),
    AndroidWorkshop(
        Playlist(
            title = "Android desde cero",
            url = "https://www.youtube.com/playlist?list=PLdIqyKXhJsgTgCnAO_j3y9Fvz5KT48K81",
            thumbnail = "images/thumbnail_workshop.png",
            description = "Workship gratuito para aprender Android desde cero, hecho por la comunidad.",
        )
    ),
}

enum class RecentBlogs(val data: BlogEntry) {
    Meetup57(
        BlogEntry(
            title = "Meetup #57: Kotlin Multiplatform is Stable!",
            url = "https://dev.to/androiddevperu/meetup-57-build-your-first-app-with-kmp-bp0",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--o8Vcpr03--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/p5edmwpvxcnryqohd17q.jpeg",
            description = "El jueves 26 de noviembre de 2023 nos visitó el GDE Yury Camacho desde Bolivia para hablarnos sobre Kotlin Multiplatform.",
        )
    ),
    DevFest2023(
        BlogEntry(
            title = "DevFest 2023 - GDG Open",
            url = "https://dev.to/androiddevperu/devfest-2023-gdg-open-1b37",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--A7FMokQZ--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/x34agc51zzdtnt6x8jbw.jpeg",
            description = "El 12 de noviembre de 2023, participamos en el DevFest 2023 del GDG Open, en donde elaboramos un taller sobre Jetpack Compose.",
        )
    ),
    BcpFeria(
        BlogEntry(
            title = "Feria de comunidades en BCP",
            url = "https://dev.to/androiddevperu/feria-de-comunidades-en-bcp-58df",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--4_TmxZwH--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/fm8vla3rsxaezcp0qvxp.jpeg",
            description = "El 22 de noviembre tuvimos la oportunidad de participar en la feria de comunidades que organizó el BCP, donde participaron más de 400 personas",
        )
    ),
    Meetup56(
        BlogEntry(
            title = "Meetup #56: Bluetooth desde 0",
            url = "https://dev.to/androiddevperu/meetup-56-controlando-bluetooh-desde-0-3j27",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--AL-Z6Dmp--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/xd3pk3kbay51di61bkiv.jpeg",
            description = "El 30 de octubre, tuvimos una charla virtual!, en nuestro meetup #56 en el cual Hansy Schmitt nos compartió sus conocimientos de Bluetooth."
        )
    ),
}

enum class Organizers(val data: Organizer) {
    Eduardo(
        Organizer(
            name = "Eduardo",
            lastName = "Medina",
            photo = "organizer_edu.png",
        )
    ),
    Bruno(
        Organizer(
            name = "Bruno",
            lastName = "Aybar",
            photo = "organizer_bruno.jpeg",
        )
    ),
    Flavio(
        Organizer(
            name = "Jose Flavio",
            lastName = "Quispe",
            photo = "organizer_flavio.jpeg",
        )
    ),
    Daniel(
        Organizer(
            name = "Daniel",
            lastName = "Anaya",
            photo = "organizer_daniel.jpeg",
        )
    ),
    Freddy(
        Organizer(
            name = "Freddy",
            lastName = "Lazo",
            photo = "organizer_freddy.jpeg",
        )
    ),
    Krum(
        Organizer(
            name = "Pedro",
            lastName = "Rau",
            alias = "Krum",
            photo = "organizer_krum.jpeg",
        )
    ),
    Josue(
        Organizer(
            name = "Josue",
            lastName = "Durand",
            photo = "organizer_josue.jpeg",
        )
    ),
    Tohure(
        Organizer(
            name = "Carlo",
            lastName = "Huaman",
            alias = "Tohure",
            photo = "organizer_tohure.jpeg",
        )
    ),
}

enum class LegacyOrganizers(val data: Organizer) {
    Jonathan(
        Organizer(
            name = "Jonathan",
            lastName = "Nolasco",
            photo = "organizer_nolasco.jpeg",
        )
    ),
}