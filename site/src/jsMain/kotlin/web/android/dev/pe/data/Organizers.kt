package web.android.dev.pe.data

data class Organizer(
    val name: String,
    val lastName: String,
    val photo: String,
    val alias: String? = null,
) {
    val fullName: String
        get() = "$name $lastName"
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