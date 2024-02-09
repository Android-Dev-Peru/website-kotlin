package home

data class Social(
    val icon: String,
    val url: String,
    val name: String = "",
)

data class BlogEntry(
    val title: String,
    val url: String,
    val thumbnail: String,
    val description: String,
)

data class Organizer(
    val name: String,
    val lastName: String,
    val photo: String,
    val alias: String? = null,
) {
    val fullName: String
        get() = "$name $lastName"
}

data class Playlist(
    val title: String,
    val url: String,
    val thumbnail: String,
    val description: String = "",
)