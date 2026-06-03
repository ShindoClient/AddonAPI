package me.miki.addon.api.config

const val PROPERTY_SENTINEL_DOUBLE = -1.0

/**
 * Annotation for addon fields that should be exposed as settings.
 *
 * When the client loads an addon, it scans fields annotated with @Property
 * and automatically bridges them into the settings UI — no need to manually
 * construct [me.miki.addon.api.setting.Setting] objects or override the
 * `settings` property unless you need extra control.
 *
 * Example usage:
 * ```kotlin
 * @Property(type = PropertyType.BOOLEAN, name = "Enabled", description = "Toggle the feature")
 * var enabled = true
 *
 * @Property(type = PropertyType.NUMBER, name = "Scale", min = 0.0, max = 2.0, step = 0.1)
 * var scale = 1.0
 * ```
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD)
annotation class Property(
    val type: PropertyType,
    val name: String = "",
    val category: String = "",
    val description: String = "",
    val hidden: Boolean = false,
    val min: Double = PROPERTY_SENTINEL_DOUBLE,
    val max: Double = PROPERTY_SENTINEL_DOUBLE,
    val step: Double = PROPERTY_SENTINEL_DOUBLE,
    val current: Double = PROPERTY_SENTINEL_DOUBLE,
    val color: Int = Int.MIN_VALUE,
    val showAlpha: Boolean = false,
    val keyCode: Int = Int.MIN_VALUE,
    val text: String = "",
    val enumName: String = "",
    val key: String = "",
)
