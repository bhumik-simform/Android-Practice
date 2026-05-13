package com.example.demo3dactivityintentfragment.model

import android.graphics.Color
import com.example.demo3dactivityintentfragment.data.allDishes
import java.util.UUID
import kotlin.collections.filter

data class Country(
    val id: UUID,
    val name: String,
    val flagEmoji: String,
    val bgColor: Int,
    val cuisineStyle: String,
    val description: String
) {
    fun dishCount() = allDishes.count { it.countryID == id }

    fun dishes() = allDishes.filter { it.countryID == id }
}