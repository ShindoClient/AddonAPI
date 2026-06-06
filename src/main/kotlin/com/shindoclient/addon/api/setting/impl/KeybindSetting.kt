package com.shindoclient.addon.api.setting.impl

import com.shindoclient.addon.api.setting.Setting

class KeybindSetting(
    name: String,
    description: String = "",
    defaultKey: Int = 0,
) : Setting(name, description) {
    override val defaultValue: Any = defaultKey
    private var keyCode: Int = defaultKey

    override fun get(): Int = keyCode

    override fun set(value: Any) {
        if (value is Int) this.keyCode = value
    }

    fun isKeyPressed(): Boolean = false // Stub - actual implementation needs LWJGL/GLFW
}
