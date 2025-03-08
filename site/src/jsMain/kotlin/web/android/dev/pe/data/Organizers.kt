package web.android.dev.pe.data

import web.android.dev.pe.Res

data class Organizer(
    val name: String,
    val lastName: String,
    val photo: String,
    val alias: String? = null,
    val socials: List<Social> = emptyList(),
) {
    val fullName: String
        get() = "$name $lastName"
}

private val baseImagePath = "/images/organizers/"

enum class Organizers(val data: Organizer) {
    Eduardo(
        Organizer(
            name = "Eduardo",
            lastName = "Medina",
            photo = "${baseImagePath}organizer_edu.png",
        )
    ),
    Bruno(
        Organizer(
            name = "Bruno",
            lastName = "Aybar",
            photo = "${baseImagePath}organizer_bruno.jpeg",
        )
    ),
    Flavio(
        Organizer(
            name = "Jose Flavio",
            lastName = "Quispe",
            photo = "${baseImagePath}organizer_flavio.jpeg",
        )
    ),
    Freddy(
        Organizer(
            name = "Freddy",
            lastName = "Lazo",
            photo = "${baseImagePath}organizer_freddy.jpeg",
        )
    ),
    Krum(
        Organizer(
            name = "Pedro",
            lastName = "Rau",
            alias = "Krum",
            photo = "${baseImagePath}organizer_krum.jpeg",
        )
    ),
    Josue(
        Organizer(
            name = "Josue",
            lastName = "Durand",
            photo = "${baseImagePath}organizer_josue.jpeg",
        )
    ),
    Tohure(
        Organizer(
            name = "Carlo",
            lastName = "Huaman",
            alias = "Tohure",
            photo = "${baseImagePath}organizer_tohure.jpeg",
        )
    ),
}

enum class LegacyOrganizers(val data: Organizer) {
    JonathanNolasco(
        Organizer(
            name = "Jonathan",
            lastName = "Nolasco",
            photo = "${baseImagePath}organizer_nolasco.jpeg",
        )
    ),
    JonathanChoy(
        Organizer(
            name = "Jonathan",
            lastName = "Choy",
            photo = "${baseImagePath}organizer_jonathan_choy.jpeg",
        )
    ),
    PabloJohnson(
        Organizer(
            name = "Pablo",
            lastName = "Johnson",
            photo = "${baseImagePath}organizer_pablo_johnson.jpeg",
        )
    ),
    PedroCarrillo(
        Organizer(
            name = "Pedro",
            lastName = "Carrillo",
            photo = "${baseImagePath}organizer_pedro_carrillo.jpeg",
        )
    ),
    Hansy(
        Organizer(
            name = "Hansy",
            lastName = "Schmitt",
            photo = "${baseImagePath}organizer_hansy.jpeg",
        )
    ),
    Daniel(
        Organizer(
            name = "Daniel",
            lastName = "Anaya",
            photo = "${baseImagePath}organizer_daniel.jpeg",
        )
    ),
}

val Volunteers_AndroidConf2024 = listOf(
    Organizer(
        name = "Alyssa",
        lastName = "Villarán",
        photo = "/events/conf2024/volunteers/aly.webp",
        socials = listOf(
            Social(Res.Icon.Instagram, "https://www.instagram.com/alevu94/"),
        ),
    ),
    Organizer(
        name = "Carlos",
        lastName = "Ugaz",
        photo = "/events/conf2024/volunteers/carlos-ugaz.webp",
        socials = listOf(
            Social(icon = Res.Icon.Twitter, url = "https://x.com/carlosgub", name = "X"),
            Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/carlosgub/", name = "LinkedIn"),
        ),
    ),
    Organizer(
        name = "Gianmarco",
        lastName = "Guerrero",
        photo = "/events/conf2024/volunteers/gianmarco.webp",
        socials = listOf(
            Social(icon = Res.Icon.Instagram, url = "https://www.instagram.com/giansecurai/", name = "Instagram"),
            Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/gianmarco-guerrero-menacho/", name = "LinkedIn"),
        ),
    ),
)
