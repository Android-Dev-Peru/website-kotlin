package web.android.dev.pe.pages.conf

import web.android.dev.pe.data.Presentation
import web.android.dev.pe.data.Social
import web.android.dev.pe.Res
import web.android.dev.pe.pages.conf.components.sections.Sponsor
import web.android.dev.pe.pages.conf.subpages.sponsorship.SponsorshipPlan

private val imageBase = "/events/conf2024"
private val photoBase = "$imageBase/speakers"
private val sponsorBase = "$imageBase/sponsors"

object ADPConf2024 {
    val sponsors = listOf(
        Sponsor(
            name = "UPC",
            url = "https://www.upc.edu.pe/",
            plan = SponsorshipPlan.Gold,
            logo = "$sponsorBase/upc.png"
        ),
        Sponsor(
            name = "HaystackNews",
            url = "https://www.haystack.tv/",
            plan = SponsorshipPlan.Gold,
            logo = "$sponsorBase/haystack_light.svg",
            darkLogo = "$sponsorBase/haystack_dark.svg"
        ),
        Sponsor(
            name = "NTT Data",
            plan = SponsorshipPlan.Gold,
            url = "https://pe.nttdata.com/",
            logo = "$sponsorBase/ntt_light.svg",
            darkLogo = "$sponsorBase/ntt_dark.svg"
        ),
        Sponsor(
            name = "APESOFT PERU",
            plan = SponsorshipPlan.Bronze,
            url = "https://www.linkedin.com/company/apesoft-peru",
            logo = "$sponsorBase/apesoft_light.webp",
            darkLogo = "$sponsorBase/apesoft_dark.webp",
        ),
    )

    val talks = listOf(
        Presentation(
            title = "Creando tu BD en Kotlin Multiplatform con SQLDelight",
            description = "En esta charla exploraremos cómo crear y gestionar una base de datos en aplicaciones multiplataforma usando Kotlin Multiplatform y SQLDelight. Veremos cómo integrar SQLDelight en una aplicación cuando este no tenga internet.",
            speakerName = "Carlos Ugaz",
            speakerRole = "Android | Kotlin Multiplatform Developer",
            speakerCompany = "",
            speakerCountry = "Perú",
            speakerPhoto = "${photoBase}/carlos-ugaz",
            socials = listOf(
                Social(icon = Res.Icon.Twitter, url = "https://x.com/carlosgub", name = "X"),
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/carlosgub/", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "Desarrollo de Apps Educativas Inclusivas en Android: El Caso de EduKuna",
            description = "En esta charla, exploraremos cómo EduKuna transformó el aprendizaje en un colegio estatal a través de su app educativa Cool Learning, diseñada exclusivamente para Android." +
                    "<br><br>" +
                    "Cool Learning es una app educativa diseñada para mejorar el aprendizaje de matemáticas en estudiantes de primaria. Ofrece tres modos de juego interactivos que permiten a los estudiantes practicar y reforzar sus habilidades matemáticas de manera divertida." +
                    "<br><br>" +
                    "Compartiremos el proceso de desarrollo de la app, desde su concepción hasta su implementación en las aulas. Además, profundizaremos en los desafíos técnicos que enfrentamos, como la falta de conectividad a internet en los salones y el uso de tablets con resoluciones diferentes y versiones antiguas de API. También explicaré la metodología aplicada en clase y, lo más importante, mostraré los sorprendentes resultados obtenidos de los estudiantes: una mejora significativa en el rendimiento académico e interés por las matemáticas.",
            speakerName = "Keneth Lopez",
            speakerRole = "CEO of EduKuna | Fullstack Developer",
            speakerCompany = "EduKuna",
            speakerCountry = "Perú",
            speakerPhoto = "${photoBase}/keneth-lopez",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/keneth-lopez/", name = "LinkedIn"),
                Social(icon = Res.Icon.Instagram, url = "https://www.instagram.com/kenethlopezzz/", name = "Instagram"),
            )
        ),
        Presentation(
            title = "Clean Architecture con Kotlin Multiplataform",
            description = "Se describirá una arquitectura para proyectos multiplataforma basada en clean architecture. Se describirá un proyecto explicando las siguientes partes:" +
                    "<br><br>" +
                    "-Capas de presentación, dominio y datos " +
                    "<br>" +
                    "-Inyección de dependencia con Koin " +
                    "<br>" +
                    "-Compose Multiplatfrom " +
                    "<br>" +
                    "-Navigation y ViewModel " +
                    "<br>" +
                    "-Kotlin Flow, Serialization, Coroutines " +
                    "<br>" +
                    "-Data: Room y Kstore",
            speakerName = "Andres Escobar",
            speakerRole = "Software Architect | Kotlin Multiplatform Developer",
            speakerCompany = "",
            speakerCountry = "Perú",
            speakerPhoto = "${photoBase}/andres-escobar",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/andres-escobar-villa/", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "Effective Fuzz Testing en Android",
            description = "Fuzz testing is a critical technique for identifying hidden vulnerabilities that traditional testing often overlooks, especially in mobile development where the diversity of devices and inputs can create unexpected challenges. In this talk, we will explore how fuzz testing can be integrated into your mobile development process to enhance software reliability and security. Attendees will learn about mobile-specific fuzzing tools, best practices for setting up effective fuzz tests in Android environments, and how to analyze the results to improve app performance and resilience. Whether you’re new to fuzz testing or looking to refine your approach, this session will provide valuable insights and practical tips to help you push your mobile applications to its limits and ensure robust performance in production environments.",
            speakerName = "Milton Condori",
            speakerRole = "Software Engineer | Android Developer | Researcher in Automated Planning",
            speakerCompany = "NTT DATA",
            speakerCountry = "Perú",
            speakerPhoto = "${photoBase}/milton-condori",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/milton761/", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "Construyendo apps para Android con Media3",
            description = "Mejorando el Rendimiento y la Eficiencia de tus Aplicaciones Multimedia",
            speakerName = "Haystack News",
            speakerRole = "Android Engineer",
            speakerCompany = "",
            speakerCountry = "Perú",
            speakerPhoto = "${photoBase}/gonzalo-cirilo",
            socials = listOf(
                Social(icon = Res.Icon.Twitter, url = "https://x.com/haystacktv", name = "X"),
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/company/haystack-tv", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "Gemini in Android. Let's build smart apps",
            description = "La IA esta de moda, escuchamos por todo lado IA, y con la llegada de Gemini las integraciones de IA a nuestras apps son mas fáciles dandole capacidades que antes no podíamos tener en nuestros dispositivos móviles, en esta charla haremos que nuestras apps móviles sean inteligentes integrándolas con Gemini.",
            speakerName = "Yury Camacho",
            speakerRole = "Staff Software Engineer @ Rappi.<br>Google Developer Expert Android 🇧🇴🇦🇷",
            speakerCompany = "Rappi",
            speakerCountry = "Bolivia",
            speakerPhoto = "${photoBase}/yury",
            socials = listOf(
                Social(icon = Res.Icon.Twitter, url = "https://x.com/camachoyury", name = "X"),
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/camachoyury", name = "LinkedIn"),
            )
        ),
    )
}