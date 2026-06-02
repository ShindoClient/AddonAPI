package me.miki.addon.api.event

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class EventTarget(val priority: Byte = 2)
