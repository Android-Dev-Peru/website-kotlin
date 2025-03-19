package web.android.dev.pe


object Routes {
    const val Home = "/"
    const val AboutUs = "/about-us"
    const val Resources = "/resources"
    const val Articles = "/articles"
    const val Subscribe = "/subscribe"
    const val PrivacyPolicy = "/privacy-policy"

    object Conf {
        object Year2024 {
            const val Index = "/conf/2024"
            const val Sponsorship = "/conf/2024/sponsorship"
            const val CodeOfConduct = "/conf/2024/coc"
            const val Speakers = "/conf/2024/speakers"
            const val Volunteers = "/conf/2024/volunteers"
            const val Agenda = "/conf/2024/agenda"
        }
        object Year2025 {
            const val Index = "/conf"
            const val Sponsorship = "/conf/sponsorship"
            const val CodeOfConduct = "/conf/coc"
            const val Speakers = "/conf/speakers"
            const val Volunteers = "/conf/volunteers"
            const val Agenda = "/conf/agenda"
        }
    }
}