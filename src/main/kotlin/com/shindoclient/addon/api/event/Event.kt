package com.shindoclient.addon.api.event

open class Event {
    var cancelled: Boolean = false
        private set

    fun cancel() {
        cancelled = true
    }
}
