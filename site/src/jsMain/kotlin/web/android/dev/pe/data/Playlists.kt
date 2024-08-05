package web.android.dev.pe.data

data class Playlist(
    val title: String,
    val url: String,
    val thumbnail: String,
    val description: String = "",
)

enum class Playlists(val data: Playlist) {
    Meetups(
        Playlist(
            title = "[LIVE] Meetups",
            url = "https://youtube.com/playlist?list=PLdIqyKXhJsgTtpZz6boXclEcuPYb-rupb&si=_efDqZYdPrGU9lTQ",
            thumbnail = "/images/thumbnail_meetup.webp",
            description = "Revisa las grabaciones de nuestros meetups pasados.",
        )
    ),
    AndroidWorkshop(
        Playlist(
            title = "Android desde cero",
            url = "https://www.youtube.com/playlist?list=PLdIqyKXhJsgTgCnAO_j3y9Fvz5KT48K81",
            thumbnail = "/images/thumbnail_workshop.png",
            description = "Workship gratuito para aprender Android desde cero, hecho por la comunidad.",
        )
    ),
}