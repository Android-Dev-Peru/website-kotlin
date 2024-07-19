package web.android.dev.pe.data

import web.android.dev.pe.Res

enum class Socials(val data: Social) {
    Whatsapp(Social(icon = Res.Icon.Whatsapp, url = Res.Links.WhatsApp, name = "WhatsApp")),
    YouTube(Social(icon = Res.Icon.YouTube, url = Res.Links.YouTube, name = "YouTube")),
    Twitter(Social(icon = Res.Icon.Twitter, url = Res.Links.Twitter, name = "Twitter")),
    Instagram(Social(icon = Res.Icon.Instagram, url = Res.Links.Instagram, name = "Instagram")),
    LinkedIn(Social(icon = Res.Icon.LinkedIn, url = Res.Links.LinkedIn, name = "LinkedIn")),
    GitHub(Social(icon = Res.Icon.GitHub, url = Res.Links.GitHub, name = "GitHub")),
    TikTok(Social(icon = Res.Icon.TikTok, url = Res.Links.TikTok, name = "TikTok")),
}