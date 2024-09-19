package web.android.dev.pe.data

data class Presentation(
    val title: String,
    val description: String,
    val speakerName: String,
    val speakerRole: String,
    val speakerCompany: String,
    val speakerCountry: String,
    val speakerPhoto: String,
    val socials: List<Social>,
)