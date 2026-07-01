package com.example.demo3dactivityintentfragment.enums

import android.graphics.Color

enum class DishType(val displayName: String) {
    VEG("Veg"),
    NON_VEG("Non-Veg"),
    VEGAN("Vegan");


    fun colorCode(): Int {
        fun convert(v: Double) = (v * 255).toInt()
        return when(this) {
            VEG -> Color.argb(convert(0.8),convert(0.20),convert(0.78),convert(0.35))
            NON_VEG -> Color.argb(convert(0.8),convert(1.00),convert(0.23),convert(0.19))
            VEGAN -> Color.argb(convert(0.8),convert(0.00),convert(0.78),convert(0.75))
        }
    }

    fun bgColorCode(): Int {
        fun convert(v: Double) = (v * 255).toInt()
        return when(this) {
            VEG -> Color.argb(convert(0.5),convert(0.20),convert(0.78),convert(0.35))
            NON_VEG -> Color.argb(convert(0.5),convert(1.00),convert(0.23),convert(0.19))
            VEGAN -> Color.argb(convert(0.5),convert(0.00),convert(0.78),convert(0.75))
        }
    }
}