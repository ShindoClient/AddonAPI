package com.shindoclient.addon.api.setting.impl

import com.shindoclient.addon.api.setting.Setting

class ColorSetting(
    name: String,
    description: String = "",
    default: Int = 0xFFFFFF,
) : Setting(name, description) {
    override val defaultValue: Any = default
    private var value: Int = default

    override fun get(): Int = value

    override fun set(value: Any) {
        if (value is Int) this.value = value
    }
}
