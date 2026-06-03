package me.miki.addon.api.event.impl

import me.miki.addon.api.event.Event

class KeyEvent(
    val keyCode: Int,
    val action: Int,
) : Event()
