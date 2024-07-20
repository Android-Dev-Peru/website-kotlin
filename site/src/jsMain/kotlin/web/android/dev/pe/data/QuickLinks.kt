package web.android.dev.pe.data

import web.android.dev.pe.Res

data class QuickLink(
    val title: String,
    val url: String,
    val leftIcon: String,
    val rightIcon: String? = null,
)

enum class QuickLinks(val data: QuickLink) {
    JoinWhatsApp(
        QuickLink(
            title = "Únete en WhatsApp",
            url = Res.Links.WhatsApp,
            leftIcon = Res.Icon.WhatsappFilled,
            rightIcon = Res.Icon.ExternalLink,
        )
    ),
    GiveATalk(
        QuickLink(
            title = "Da una charla",
            url = Res.Links.TalkProposal,
            leftIcon = Res.Icon.Speaker,
            rightIcon = Res.Icon.ExternalLink,
        )
    ),
    FollowLinkedIn(
        QuickLink(
            title = "Síguenos en LinkedIn",
            url = Res.Links.LinkedIn,
            leftIcon = Res.Icon.LinkedinFilled,
            rightIcon = Res.Icon.ExternalLink,
        )
    ),
}