package web.android.dev.pe.pages.conf.year_2025

import web.android.dev.pe.data.Presentation
import web.android.dev.pe.data.Social
import web.android.dev.pe.Res
import web.android.dev.pe.pages.conf.year_2025.components.sections.AgendaEntry
import web.android.dev.pe.pages.conf.year_2025.components.sections.Sponsor
import web.android.dev.pe.pages.conf.year_2025.subpages.sponsorship.SponsorshipPlan

private val imageBase = "/events/conf2025"
private val photoBase = "$imageBase/speakers"
private val sponsorBase = "$imageBase/sponsors"

object ConferenceDetails {
    val sponsors = listOf(
        Sponsor(
            name = "UPC",
            url = "https://www.upc.edu.pe/",
            plan = SponsorshipPlan.Gold,
            logo = "${sponsorBase}/upc.png"
        ),
        Sponsor(
            name = "Eventbrite",
            plan = SponsorshipPlan.Gold,
            url = "https://eventbrite.com/",
            logo = "$sponsorBase/eventbrite_light.png",
            darkLogo = "$sponsorBase/eventbrite_dark.png",
        ),
        Sponsor(
            name = "Sessionize",
            plan = SponsorshipPlan.Gold,
            url = "https://sessionize.com/",
            logo = "$sponsorBase/sessionize_light.png",
            darkLogo = "$sponsorBase/sessionize_dark.png",
        ),
    )

    val talks = listOf(
        Presentation(
            title = "Protección de credenciales en Android: DataStore, Keystore, TEE y más",
            description = "La seguridad en Android no puede reducirse a almacenar un token en DataStore o a mostrar un lector biometrico (BiometricPrompt). " +
                    "Detrás de un inicio de sesión aparentemente simple existen múltiples capas que garantizan la protección de las credenciales a lo largo " +
                    "de su ciclo de vida. <br><br>En esta charla exploraremos cómo Android provee un ecosistema robusto para salvaguardar la información sensible: " +
                    "desde el uso de Cipher y Keystore, hasta la integración con Trusted Execution Environment (TEE) y Secure Element (SE). Revisaremos " +
                    "algoritmos de cifrado y flujos de encriptación/desencriptación aplicados en escenarios reales. Todo ello será mostrado en una demo " +
                    "técnica que implementa un flujo de autenticación con password y biometría, como los que utilizan aplicaciones bancarias y empresariales. " +
                    "El objetivo es proveer a ingenieros Android de nivel senior criterios prácticos y técnicos para diseñar mecanismos de seguridad sólidos que " +
                    "respondan a riesgos reales en sus aplicaciones.",
            speakerName = "Fahed Hermoza",
            speakerRole = "Senior Android Engineer",
            speakerCompany = "",
            speakerCountry = "Perú",
            speakerPhoto = "$photoBase/fahed",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/fahedhermoza/", name = "LinkedIn"),
                Social(icon = Res.Icon.Twitter, url = "https://x.com/FahedHermoza", name = "X"),
            )
        ),
        Presentation(
            title = "De ticket a PR en Android: cómo uso Cursor para crear features cada día",
            description = "Cómo uso Cursor para crear features en multimódulo: prompts, scaffold, pruebas y PR. Mejores prácticas de fronteras y Gradle para builds" +
                    "más rápidos y menos errores. Demo y checklist final.",
            speakerName = "Sebastian Valero",
            speakerRole = "Senior Android Developer",
            speakerCompany = "",
            speakerCountry = "Colombia",
            speakerPhoto = "$photoBase/sebastian",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/sebastian-valero-vanegas/", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "KMP, Swift-First — Make shared code feel native on iOS",
            description = "Aprende a diseñar un módulo multiplataforma de Kotlin, desde el punto de vista de desarollador iOS. Haz que se sienta como Swift: async/await (sin callbacks), generación de errores de dominio, y Swift-friendly enums.",
            speakerName = "Jeans Ruiz",
            speakerRole = "iOS Developer @ SOSAFE",
            speakerCompany = "",
            speakerCountry = "Perú",
            speakerPhoto = "$photoBase/jeans",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/jeans-ruiz/", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "Editor de texto en KMP",
            description = "Una implementación nativa de un editor de texto enriquecido usando Kotlin Multiplataforma para Android y iOS desde cero.",
            speakerName = "Jorge Rodríguez",
            speakerRole = "Android Software Designer",
            speakerCompany = "",
            speakerCountry = "Perú",
            speakerPhoto = "$photoBase/jorge",
            socials = listOf(
                Social(icon = Res.Icon.LinkedIn, url = "http://linkedin.com/in/jorge-rodríguez-castillo", name = "LinkedIn"),
            )
        ),
        Presentation(
            title = "Android Codes: The Rise of AI",
            description = "La inteligencia artificial ha llegado para quedarse, y Android Studio se ha convertido en el epicentro de esta transformación.<br><br>" +
                    "En esta charla exploraremos cómo la IA está cambiando el día a día del desarrollo Android a través de:<br>" +
                    "Gemini en Android Studio: desde el chat y el autocompletado hasta el poderoso Agent Mode, capaz de generar tests, refactorizar código y " +
                    "corregir errores con tu aprobación." +
                    "MCP (Model Context Protocol): el nuevo “USB-C de los agentes”, que conecta el IDE con herramientas como GitHub y Figma para integrar " +
                    "issues y diseños directamente en tu app.<br>" +
                    "Plugins como Firebender y Windsurf: aliados que amplían Android Studio con paneles MCP, ejecución de Gradle/tests y experiencias de\n" +
                    "desarrollo aumentadas por IA." +
                    "A través de demos prácticas, mostraremos cómo estas herramientas actúan como verdaderos “devs juniors” que escriben, prueban y\n" +
                    "conectan tu código, acelerando la productividad y elevando la calidad de las apps Android.",
            speakerName = "Yury Camacho",
            speakerRole = "Google Developer Expert | Android 🇧🇴🇦🇷",
            speakerCompany = "",
            speakerCountry = "Bolivia",
            speakerPhoto = "$photoBase/yury",
            socials = listOf(
                Social(icon = Res.Icon.Twitter, url = "https://x.com/camachoyury", name = "X"),
                Social(icon = Res.Icon.LinkedIn, url = "https://www.linkedin.com/in/camachoyury", name = "LinkedIn"),
            )
        ),
    )

    val talkFahed = talks[0]
    val talkSebastian = talks[1]
    val talkJeans = talks[2]
    val talkJorge = talks[3]
    val talkYury = talks[4]

    val agenda = listOf(
        AgendaEntry.Other(
            title = "Registro y presentación de la comunidad",
            time = "8:30 - 9:25 AM",
            description = "¡Empieza el evento!",
        ),
        AgendaEntry.Talk(
            presentation = talkFahed,
            time = "9:25 - 10:05 AM",
        ),
        AgendaEntry.Talk(
            presentation = talkSebastian,
            time = "10:05 - 10:45 AM",
        ),
        AgendaEntry.Talk(
            presentation = talkYury,
            time = "10:45 - 11:25 AM",
        ),
        AgendaEntry.Other(
            title = "Sorteos y Fotos",
            time = "11:25 - 11:50 AM",
            description = "Participa en sorteos para ganar swag",
        ),
        AgendaEntry.Other(
            title = "Networking",
            time = "11:50 - 12:30 PM",
            description = "Disfruta de un break para conocer a otros asistentes.",
        ),
        AgendaEntry.Talk(
            presentation = talkJeans,
            time = "12:30 - 1:10 PM",
        ),
        AgendaEntry.Talk(
            presentation = talkJorge,
            time = "1:10 - 1:50 PM",
        ),
        AgendaEntry.Other(
            title = "Cierre del evento",
            time = "1:50 - 2:00 PM",
            description = "Hora de despedirse. ¡No te vayas antes de la foto final!",
        ),
    )
}