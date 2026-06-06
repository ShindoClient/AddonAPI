package com.shindoclient.addon.api.event.impl

import com.shindoclient.addon.api.event.Event

class MouseEvent(
    val type: Type,
    val button: Int = -1,
    val scrollAmount: Int = 0,
) : Event() {
    enum class Type {
        CLICK,
        RELEASE,
        SCROLL,
    }
}
