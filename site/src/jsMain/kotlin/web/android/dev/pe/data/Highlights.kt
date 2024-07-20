package web.android.dev.pe.data

import web.android.dev.pe.Res

data class CardContent(
    val title: String,
    val description: List<String>,
    val image: String,
    val cta: String,
    val url: String,
)

val Highlights = listOf(
    CardContent(
        title = "Kotlin Conf",
        description = listOf(
            "El pasado Junio nos reunimos presencialmente para el Kotlin Conf - Lima.",
            "",
            "🗓 Fecha: miércoles 26 de junio",
            "⏰ Hora: 7PM 🇵🇪 🇨🇴",
            "🏢 Local: NTT Data",
        ),
        image = "reunion.png",
        cta = "Ver grabación",
        url = Res.Links.KotlinConf2024,
    ),
    CardContent(
        title = "Encuesta salarial 2023",
        description = listOf(
            "La transparencia puede ayudar a reducir brechas salariales. Este mes realizamos encuestas anónimas y recibimos +100 respuestas de mobile devs en LATAM."
        ),
        image = "survey.png",
        cta = "Mira los resultados",
        url = Res.Links.Salarios2023
    ),
)