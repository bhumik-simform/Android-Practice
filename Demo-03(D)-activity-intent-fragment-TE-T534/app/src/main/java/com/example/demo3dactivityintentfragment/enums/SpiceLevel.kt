package com.example.demo3dactivityintentfragment.enums;

import android.graphics.Color

enum class SpiceLevel(val level:Int) {
    NONE(0),
    MILD(1),
    MEDIUM(2),
    SPICY(3),
    EXTRA_HOT(4);

    val spiceLevelName:String
        get() = when(this) {
            NONE -> "None"
            MILD -> "Mild"
            MEDIUM -> "Medium"
            SPICY -> "Spicy"
            EXTRA_HOT -> "Extra Hot"
        }

    val label: String
        get() = when (this) {
            NONE -> "None"
            MILD -> "🌶 Mild"
            MEDIUM -> "🌶🌶 Medium"
            SPICY -> "🌶🌶🌶 Spicy"
            EXTRA_HOT -> "🌶🌶🌶🌶 Extra Hot"
        }

    fun badgeColor(): Int {
        fun convert(v: Double) = (v*255).toInt()
        return when(this) {
            NONE -> Color.argb(255,209,209,214)
            MILD -> Color.argb(255,convert(1.00),convert(0.85),convert(0.40))
            MEDIUM -> Color.argb(255,convert(1.00),convert(0.60),convert(0.20))
            SPICY -> Color.argb(255,convert(0.95),convert(0.30),convert(0.10))
            EXTRA_HOT -> Color.argb(255,convert(0.75),convert(0.05),convert(0.05))
        }
    }

}