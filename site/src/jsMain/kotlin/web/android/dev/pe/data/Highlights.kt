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
        title = { ResStrings.home_highlights_card_event_title },
        description = { ResStrings.home_highlights_card_event_description},
        image = "/images/reunion.png",
        cta = { ResStrings.home_highlights_card_event_cta },
        url = Res.Links.Meetup65,
    ),
    CardContent(
        title = { ResStrings.home_highlights_card_salary_2024_title },
        description = { ResStrings.home_highlights_card_salary_2024_description },
        image = "/images/survey.png",
        cta = { ResStrings.home_highlights_card_salary_2024_cta },
        url = Res.Links.Salarios2024
    ),
)