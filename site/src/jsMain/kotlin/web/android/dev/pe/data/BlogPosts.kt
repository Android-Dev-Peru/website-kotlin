package web.android.dev.pe.data

import strings.ResStrings

data class BlogEntry(
    val title: ()-> String,
    val url: String,
    val thumbnail: String,
    val description: ()-> String,
)

enum class RecentBlogs(val data: BlogEntry) {
    AndroidDevPeruConf24(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_adpconf_24 },
            url = "https://dev.to/androiddevperu/android-dev-peru-conf-2023-4ao3",
            thumbnail = "https://media2.dev.to/dynamic/image/width=800%2Cheight=%2Cfit=scale-down%2Cgravity=auto%2Cformat=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2Fzc07gtqjwf39r5qczukn.jpeg",
            description = { ResStrings.resources_blog_posts_adpconf_24_desc },
        )
    ),
    Meetup60(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_meetup_60 },
            url = "https://dev.to/androiddevperu/meetup-60-graphql-y-seniority-en-la-industria-tech-o67",
            thumbnail = "https://media2.dev.to/cdn-cgi/image/width=800%2Cheight=%2Cfit=scale-down%2Cgravity=auto%2Cformat=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2Faomncs6d5ckqehackhp9.png",
            description = { ResStrings.resources_blog_posts_meetup_60_desc },
        )
    ),
    Meetup58(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_meetup_58 },
            url = "https://dev.to/androiddevperu/meetup-58-precompose-vs-decompose-vs-voyager-en-kmp-45gb",
            thumbnail = "https://media2.dev.to/cdn-cgi/image/width=800%2Cheight=%2Cfit=scale-down%2Cgravity=auto%2Cformat=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2Flmacvwpxs7qy8exidz8w.png",
            description = { ResStrings.resources_blog_posts_meetup_58_desc },
        )
    ),
    Meetup57(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_meetup_57 },
            url = "https://dev.to/androiddevperu/meetup-57-build-your-first-app-with-kmp-bp0",
            thumbnail = "https://media2.dev.to/dynamic/image/width=800%2Cheight=%2Cfit=scale-down%2Cgravity=auto%2Cformat=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2Fp5edmwpvxcnryqohd17q.jpeg",
            description = { ResStrings.resources_blog_posts_meetup_57_desc },
        )
    ),
    DevFest2023(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_devfest_2023},
            url = "https://dev.to/androiddevperu/devfest-2023-gdg-open-1b37",
            thumbnail = "https://dev-to-uploads.s3.amazonaws.com/uploads/articles/x34agc51zzdtnt6x8jbw.jpeg",
            description = { ResStrings.resources_blog_posts_devfest_2023_desc },
        )
    ),
    BcpFeria(
        BlogEntry(
            title = { ResStrings.resources_blog_posts_bcp },
            url = "https://dev.to/androiddevperu/feria-de-comunidades-en-bcp-58df",
            thumbnail = "https://media2.dev.to/dynamic/image/width=800%2Cheight=%2Cfit=scale-down%2Cgravity=auto%2Cformat=auto/https%3A%2F%2Fdev-to-uploads.s3.amazonaws.com%2Fuploads%2Farticles%2F5ur52ypi7mrcwwvti0sw.jpeg",
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