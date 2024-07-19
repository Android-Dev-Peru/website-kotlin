package web.android.dev.pe.data

data class Social(
    val icon: String,
    val url: String,
    val name: String = "",
)

data class QuickLink(
    val title: String,
    val url: String,
    val leftIcon: String,
    val rightIcon: String? = null,
)
