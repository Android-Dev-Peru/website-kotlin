package web.android.dev.pe.data

import web.android.dev.pe.Res

data class Social(
    val icon: String,
    val url: String,
    val name: String = "",
)

val Socials = listOf(
    Social(icon = Res.Icon.Whatsapp, url = Res.Links.WhatsApp, name = "WhatsApp"),
    Social(icon = Res.Icon.YouTube, url = Res.Links.YouTube, name = "YouTube"),
    Social(icon = Res.Icon.Twitter, url = Res.Links.Twitter, name = "Twitter"),
    Social(icon = Res.Icon.Instagram, url = Res.Links.Instagram, name = "Instagram"),
    Social(icon = Res.Icon.LinkedIn, url = Res.Links.LinkedIn, name = "LinkedIn"),
    Social(icon = Res.Icon.GitHub, url = Res.Links.GitHub, name = "GitHub"),
    Social(icon = Res.Icon.TikTok, url = Res.Links.TikTok, name = "TikTok"),
)