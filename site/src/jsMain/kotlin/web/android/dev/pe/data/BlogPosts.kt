package web.android.dev.pe.data

import strings.ResStrings

data class BlogEntry(
    val title: ()-> String,
    val url: String,
    val thumbnail: String,
    val description: ()-> String,
)

enum class RecentBlogs(val data: BlogEntry) {
    Meetup57(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_meetup_57 },
            url = "https://dev.to/androiddevperu/meetup-57-build-your-first-app-with-kmp-bp0",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--o8Vcpr03--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/p5edmwpvxcnryqohd17q.jpeg",
            description = { ResStrings.resources_blog_posts_meetup_57_desc },
        )
    ),
    DevFest2023(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_devfest_2023},
            url = "https://dev.to/androiddevperu/devfest-2023-gdg-open-1b37",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--A7FMokQZ--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/x34agc51zzdtnt6x8jbw.jpeg",
            description = { ResStrings.resources_blog_posts_devfest_2023_desc },
        )
    ),
    BcpFeria(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_bcp },
            url = "https://dev.to/androiddevperu/feria-de-comunidades-en-bcp-58df",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--4_TmxZwH--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/fm8vla3rsxaezcp0qvxp.jpeg",
            description = { ResStrings.resources_blog_posts_bcp_desc },
        )
    ),
    Meetup56(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_meetup_56 },
            url = "https://dev.to/androiddevperu/meetup-56-controlando-bluetooh-desde-0-3j27",
            thumbnail = "https://res.cloudinary.com/practicaldev/image/fetch/s--AL-Z6Dmp--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_800/https://dev-to-uploads.s3.amazonaws.com/uploads/articles/xd3pk3kbay51di61bkiv.jpeg",
            description = { ResStrings.resources_blog_posts_meetup_56_desc },
        )
    ),
}