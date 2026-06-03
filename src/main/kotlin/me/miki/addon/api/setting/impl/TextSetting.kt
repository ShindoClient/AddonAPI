package me.miki.addon.api.setting.impl

import me.miki.addon.api.setting.Setting

class TextSetting(
    name: String,
    description: String = "",
    default: String = "",
) : Setting(name, description) {
    override val defaultValue: Any = default
    private var value: String = default

    override fun get(): String = value

    override fun set(value: Any) {
        if (value is String) this.value = value
    }
}
