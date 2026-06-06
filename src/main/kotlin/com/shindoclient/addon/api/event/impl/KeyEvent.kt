package com.shindoclient.addon.api.event.impl

import com.shindoclient.addon.api.event.Event

class KeyEvent(
    val keyCode: Int,
    val action: Int,
) : Event()
