package me.miki.addon.api

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class AddonInfo(
    val id: String,
    val name: String,
    val version: String,
    val description: String,
    val author: String,
    val icon: String = "",
    val type: String = "OTHER",
)
