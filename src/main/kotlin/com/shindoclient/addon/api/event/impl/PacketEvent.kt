package com.shindoclient.addon.api.event.impl

import com.shindoclient.addon.api.event.Event

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
