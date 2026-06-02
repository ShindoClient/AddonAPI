package me.miki.addon.api

import me.miki.addon.api.event.EventManager
import me.miki.addon.api.logger.AddonLogger

abstract class ShindoAddon {
    abstract val info: AddonInfo
    val logger: AddonLogger = AddonLogger(this)
    val eventManager: EventManager = EventManager()

    open fun onEnable() {}
    open fun onDisable() {}

    fun registerEvents(listener: Any) {
        eventManager.register(listener)
    }

    fun unregisterEvents(listener: Any) {
        eventManager.unregister(listener)
    }
}
