package web.android.dev.pe.data

import strings.ResStrings
import web.android.dev.pe.Res

data class CardContent(
    val title: () -> String,
    val description: () -> String,
    val image: String,
    val cta: () -> String,
    val url: String,
)

val Highlights = listOf(
    CardContent(
        title = { ResStrings.home_highlights_card_kotlin_conf_title },
        description = { ResStrings.home_highlights_card_kotlin_conf_description},
        image = "/images/reunion.png",
        cta = { ResStrings.home_highlights_card_kotlin_conf_cta },
        url = Res.Links.KotlinConf2024,
    ),
    CardContent(
        title = { ResStrings.home_highlights_card_salary_2023_title },
        description = { ResStrings.home_highlights_card_salary_2023_description },
        image = "/images/survey.png",
        cta = { ResStrings.home_highlights_card_salary_2023_cta },
        url = Res.Links.Salarios2023
    ),
)