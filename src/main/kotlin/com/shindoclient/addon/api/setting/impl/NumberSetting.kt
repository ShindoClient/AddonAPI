package com.shindoclient.addon.api.setting.impl

import com.shindoclient.addon.api.setting.Setting

class NumberSetting(
    name: String,
    description: String = "",
    default: Double = 0.0,
    val minimum: Double = 0.0,
    val maximum: Double = 100.0,
    val step: Double = 1.0,
) : Setting(name, description) {
    override val defaultValue: Any = default
    private var value: Double = default

    override fun get(): Double = value

    override fun set(value: Any) {
        if (value is Number) {
            this.value = value.toDouble().coerceIn(minimum, maximum)
        }
    }
}
