package me.miki.addon.api.setting

abstract class Setting(
    val name: String,
    val description: String = "",
) {
    abstract val defaultValue: Any

    abstract fun get(): Any

    abstract fun set(value: Any)

    open fun reset() = set(defaultValue)
}
