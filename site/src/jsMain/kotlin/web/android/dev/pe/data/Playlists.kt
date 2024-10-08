package web.android.dev.pe.data

import strings.ResStrings

data class Playlist(
    val title: () -> String,
    val url: String,
    val thumbnail: String,
    val description: () -> String = { "" },
)

enum class Playlists(val data: Playlist) {
    Meetups(
        Playlist(
            title = { ResStrings.resources_playlists_card_meetups },
            url = "https://youtube.com/playlist?list=PLdIqyKXhJsgTtpZz6boXclEcuPYb-rupb&si=_efDqZYdPrGU9lTQ",
            thumbnail = "/images/thumbnail_meetup.webp",
            description = { ResStrings.resources_playlists_card_meetups_desc },
        )
    ),
    AndroidWorkshop(
        Playlist(
            title = { ResStrings.resources_playlists_card_android_workshop },
            url = "https://www.youtube.com/playlist?list=PLdIqyKXhJsgTgCnAO_j3y9Fvz5KT48K81",
            thumbnail = "/images/thumbnail_workshop.png",
            description = { ResStrings.resources_playlists_card_android_workshop_desc },
        )
    ),
}