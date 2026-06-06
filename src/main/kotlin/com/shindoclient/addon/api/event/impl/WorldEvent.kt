package com.shindoclient.addon.api.event.impl

import com.shindoclient.addon.api.event.Event

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
