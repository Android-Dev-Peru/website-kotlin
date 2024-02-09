package utils

fun String.asSlug() = this.replace(" ", "-").lowercase()