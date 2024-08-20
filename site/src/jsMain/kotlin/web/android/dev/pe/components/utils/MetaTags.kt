package web.android.dev.pe.components.utils

import kotlinx.browser.document

enum class MetaTag(val value: String) {
    TITLE("title"),
    DESCRIPTION("description"),

    // Facebook meta tags
    OG_URL("og:url"),
    OG_TITLE("og:title"),
    OG_DESCRIPTION("og:description"),
    OG_IMAGE("og:image"),
    OG_LOCALE("og:locale"),

    // Twitter meta tags
    TWITTER_URL("twitter:url"),
    TWITTER_TITLE("twitter:title"),
    TWITTER_DESCRIPTION("twitter:description"),
    TWITTER_IMAGE("twitter:image"),
}

fun modifyMetaTag(tag: MetaTag, value: String) {
    document
        .querySelector("""meta[name="${tag.value}"]""")
        ?.setAttribute("content", value)
}
