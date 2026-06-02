package me.miki.addon.api.logger

import me.miki.addon.api.ShindoAddon

class AddonLogger(private val addon: ShindoAddon) {
    private val tag: String get() = "[${addon.info.name}]"

    fun info(message: String) {
        println("$tag INFO: $message")
    }

    fun warn(message: String) {
        println("$tag WARN: $message")
    }

    fun error(message: String) {
        System.err.println("$tag ERROR: $message")
    }

    fun error(message: String, throwable: Throwable) {
        System.err.println("$tag ERROR: $message")
        throwable.printStackTrace()
    }

    fun debug(message: String) {
        println("$tag DEBUG: $message")
    }
}
