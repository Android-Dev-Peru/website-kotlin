package web.android.dev.pe.data

import strings.ResStrings
import web.android.dev.pe.Res

data class QuickLink(
    val title: () -> String,
    val url: String,
    val leftIcon: String,
    val rightIcon: String? = null,
)

enum class QuickLinks(val data: QuickLink) {
    JoinWhatsApp(
        QuickLink(
            title = { ResStrings.home_quick_links_wsp },
            url = Res.Links.WhatsApp,
            leftIcon = Res.Icon.WhatsappFilled,
            rightIcon = Res.Icon.ExternalLink,
        )
    ),
    GiveATalk(
        QuickLink(
            title = { ResStrings.home_quick_links_talk },
            url = Res.Links.TalkProposal,
            leftIcon = Res.Icon.Speaker,
            rightIcon = Res.Icon.ExternalLink,
        )
    ),
    FollowLinkedIn(
        QuickLink(
            title = { ResStrings.home_quick_links_linkedin },
            url = Res.Links.LinkedIn,
            leftIcon = Res.Icon.LinkedinFilled,
            rightIcon = Res.Icon.ExternalLink,
        )
    ),
}