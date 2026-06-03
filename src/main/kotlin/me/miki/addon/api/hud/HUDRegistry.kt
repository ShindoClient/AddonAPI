package me.miki.addon.api.hud

import me.miki.addon.api.graphics.NanoVG

class HUDRegistration(
    val id: String,
    val name: String,
    val drawFunction: (HUDContext) -> Unit,
)

data class HUDContext(
    val width: Float,
    val height: Float,
    val partialTicks: Float,
    val nanoVG: NanoVG? = null,
)

object HUDRegistry {
    private val elements = mutableListOf<HUDRegistration>()

    fun register(element: HUDRegistration) {
        elements.add(element)
    }

    fun unregister(id: String) {
        elements.removeAll { it.id == id }
    }

    fun getElements(): List<HUDRegistration> = elements.toList()

    fun clear() {
        elements.clear()
    }
}
