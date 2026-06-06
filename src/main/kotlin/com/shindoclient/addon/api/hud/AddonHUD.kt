package com.shindoclient.addon.api.hud

/**
 * Abstract HUD element that external addons can register.
 *
 * The shindo-client bridges this into the client's HUD system so it
 * appears in the HudEditor and is persisted in profiles (position, size, etc.).
 *
 * @param name         Display name shown in HudEditor
 * @param initialWidth Default width (can be resized by user)
 * @param initialHeight Default height (can be resized by user)
 */
abstract class AddonHUD(
    val name: String,
    initialWidth: Int = 150,
    initialHeight: Int = 100,
) {
    /** Current width of this HUD (updated by the bridge on resize). */
    var width: Int = initialWidth

    /** Current height of this HUD (updated by the bridge on resize). */
    var height: Int = initialHeight

    /** Current X position (updated by the bridge on drag). */
    var x: Int = 100

    /** Current Y position (updated by the bridge on drag). */
    var y: Int = 100

    /**
     * Called every frame to render this HUD element.
     *
     * @param context Context providing rendering dimensions, partial ticks, and
     *                access to NanoVG drawing (via Shindo.getInstance()).
     */
    abstract fun onRender(context: HUDContext)
}
