package me.miki.addon.api.setting

class BooleanSetting(
    name: String,
    description: String = "",
    default: Boolean = false,
) : Setting(name, description) {
    override val defaultValue: Any = default
    private var value: Boolean = default

    override fun get(): Boolean = value
    override fun set(value: Any) {
        if (value is Boolean) this.value = value
    }

    fun toggle() {
        value = !value
    }
}
