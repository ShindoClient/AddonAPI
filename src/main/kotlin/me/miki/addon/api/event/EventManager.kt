package me.miki.addon.api.event

class EventManager {
    private val listeners = mutableMapOf<Class<*>, MutableList<Any>>()

    fun register(listener: Any) {
        val methods = listener::class.java.declaredMethods
        for (method in methods) {
            if (method.isAnnotationPresent(EventTarget::class.java) &&
                method.parameterTypes.size == 1 &&
                Event::class.java.isAssignableFrom(method.parameterTypes[0])
            ) {
                val eventClass = method.parameterTypes[0] as Class<out Event>
                listeners.getOrPut(eventClass) { mutableListOf() }.add(listener)
            }
        }
    }

    fun unregister(listener: Any) {
        listeners.values.forEach { it.remove(listener) }
        listeners.entries.removeIf { it.value.isEmpty() }
    }

    fun call(event: Event) {
        val eventClass = event.javaClass
        var cls: Class<*>? = eventClass
        val invoked = mutableSetOf<Any>()

        while (cls != null && Event::class.java.isAssignableFrom(cls)) {
            val eventListeners = listeners[cls]
            if (eventListeners != null) {
                for (listener in eventListeners) {
                    if (listener in invoked) continue
                    invoked.add(listener)
                    for (method in listener::class.java.declaredMethods) {
                        if (method.isAnnotationPresent(EventTarget::class.java) &&
                            method.parameterTypes.size == 1 &&
                            method.parameterTypes[0] == eventClass
                        ) {
                            method.isAccessible = true
                            try {
                                method.invoke(listener, event)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }
                    }
                }
            }
            cls = cls.superclass
        }
    }

    fun clear() {
        listeners.clear()
    }
}
