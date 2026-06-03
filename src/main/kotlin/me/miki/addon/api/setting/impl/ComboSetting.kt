package me.miki.addon.api.setting.impl

import me.miki.addon.api.setting.Setting

class ComboSetting(
    name: String,
    description: String = "",
    val options: Array<String>,
    defaultIndex: Int = 0,
) : Setting(name, description) {
    override val defaultValue: Any = defaultIndex
    private var selectedIndex: Int = defaultIndex.coerceIn(0, options.size - 1)

    override fun get(): Int = selectedIndex

    override fun set(value: Any) {
        if (value is Int) {
            selectedIndex = value.coerceIn(0, options.size - 1)
        }
    }

    fun getSelected(): String = options[selectedIndex]

    fun getOptions(): List<String> = options.toList()
}
