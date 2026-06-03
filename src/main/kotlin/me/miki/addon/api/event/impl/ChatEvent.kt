package me.miki.addon.api.event.impl

import me.miki.addon.api.event.Event

class ChatEvent(
    val message: String,
) : Event()
