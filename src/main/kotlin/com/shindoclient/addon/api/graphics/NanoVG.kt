package com.shindoclient.addon.api.graphics

/**
 * NanoVG drawing interface exposed to addons.
 *
 * Colors are packed ARGB integers: 0xAARRGGBB.
 * Use [rgba] / [rgb] to construct them.
 *
 * Font names reference fonts loaded by the client's FontManager.
 * Use constants from [Fonts] for well-known fonts.
 *
 * All drawing operations are relative to the client's current
 * NanoVG context and coordinate system.  Save/Restore boundaries
 * are valid only within the render frame they were created in.
 */
interface NanoVG {

    // ── Colour helpers ───────────────────────────────────────────────

    /** Pack ARGB into a single int. */
    fun rgba(r: Int, g: Int, b: Int, a: Int): Int

    /** Replace the alpha channel of [color] with [alpha]. */
    fun rgba(color: Int, alpha: Int): Int

    /** Fully opaque ARGB int (alpha = 255). */
    fun rgb(r: Int, g: Int, b: Int): Int

    // ─── Shapes (filled) ─────────────────────────────────────────────

    fun drawRect(x: Float, y: Float, w: Float, h: Float, color: Int)

    fun drawRoundedRect(x: Float, y: Float, w: Float, h: Float, radius: Float, color: Int)

    fun drawRoundedRectVarying(
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        topLeft: Float,
        topRight: Float,
        bottomLeft: Float,
        bottomRight: Float,
        color: Int,
    )

    fun drawCircle(cx: Float, cy: Float, radius: Float, color: Int)

    // ─── Outlines ────────────────────────────────────────────────────

    fun drawOutlineRoundedRect(
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        radius: Float,
        strokeWidth: Float,
        color: Int,
    )

    fun drawLine(
        x1: Float,
        y1: Float,
        x2: Float,
        y2: Float,
        strokeWidth: Float,
        color: Int,
    )

    fun drawArc(
        cx: Float,
        cy: Float,
        radius: Float,
        startAngleDeg: Float,
        endAngleDeg: Float,
        strokeWidth: Float,
        color: Int,
    )

    // ─── Gradients ───────────────────────────────────────────────────

    fun drawVerticalGradientRect(
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        colorTop: Int,
        colorBottom: Int,
    )

    fun drawHorizontalGradientRect(
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        colorLeft: Int,
        colorRight: Int,
    )

    fun drawGradientRoundedRect(
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        radius: Float,
        color1: Int,
        color2: Int,
    )

    // ─── Text ────────────────────────────────────────────────────────

    fun drawText(
        text: String,
        x: Float,
        y: Float,
        color: Int,
        fontSize: Float,
        font: String,
    )

    fun drawCenteredText(
        text: String,
        cx: Float,
        cy: Float,
        color: Int,
        fontSize: Float,
        font: String,
    )

    fun drawTextBox(
        text: String,
        x: Float,
        y: Float,
        maxWidth: Float,
        color: Int,
        fontSize: Float,
        font: String,
    )

    fun getTextWidth(text: String, fontSize: Float, font: String): Float

    fun getTextHeight(text: String, fontSize: Float, font: String): Float

    // ─── State ───────────────────────────────────────────────────────

    fun save()
    fun restore()
    fun translate(dx: Float, dy: Float)
    fun scale(sx: Float, sy: Float)
    fun rotate(angleRadians: Float)
    fun setAlpha(alpha: Float)

    /** Scissor test – only pixels inside the rect will be affected. */
    fun scissor(x: Float, y: Float, w: Float, h: Float)
    fun resetScissor()
}
