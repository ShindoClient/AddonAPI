package com.shindoclient.addon.api.command

abstract class AddonCommand(
    val prefix: String,
    val description: String = "",
) {
    abstract fun onCommand(args: List<String>)
}
