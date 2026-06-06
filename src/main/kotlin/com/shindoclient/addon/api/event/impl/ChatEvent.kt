package com.shindoclient.addon.api.event.impl

import com.shindoclient.addon.api.event.Event

class ChatEvent(
    val message: String,
) : Event()
