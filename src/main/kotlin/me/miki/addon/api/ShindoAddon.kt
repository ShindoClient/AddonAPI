package me.miki.addon.api

import me.miki.addon.api.command.AddonCommand
import me.miki.addon.api.event.EventManager
import me.miki.addon.api.hud.AddonHUD
import me.miki.addon.api.logger.AddonLogger
import me.miki.addon.api.setting.Setting

abstract class ShindoAddon {
    abstract val info: AddonInfo
    val logger: AddonLogger = AddonLogger(this)
    val eventManager: EventManager = EventManager()

    /** HUD elements to register with the client's HudEditor. */
    open val huds: List<AddonHUD> = emptyList()

    /** Chat commands to register with the client's command system. */
    open val commands: List<AddonCommand> = emptyList()

    /** Settings exposed to the client's settings UI and profile system. */
    open val settings: List<Setting> = emptyList()

    open fun onEnable() {}
    open fun onDisable() {}

    /** Called when the profile is being saved — return KV pairs to persist. */
    open fun onConfigSave(): Map<String, String> = emptyMap()

    /** Called when the profile is loaded — receive previously saved KV pairs. */
    open fun onConfigLoad(data: Map<String, String>) {}

    fun registerEvents(listener: Any) {
        eventManager.register(listener)
    }

    fun unregisterEvents(listener: Any) {
        eventManager.unregister(listener)
    }
}
