package me.miki.addon.api.event.impl

import me.miki.addon.api.event.Event

class PacketEvent(
    val type: Type,
    val packetClass: String,
    val packetString: String,
) : Event() {
    enum class Type {
        SEND,
        RECEIVE,
    }
}
