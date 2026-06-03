package me.miki.addon.api.event.impl

import me.miki.addon.api.event.Event

class WorldEvent(
    val type: Type,
    val serverIp: String = "",
) : Event() {
    enum class Type {
        LOAD,
        JOIN_SERVER,
        LEAVE_SERVER,
    }
}
