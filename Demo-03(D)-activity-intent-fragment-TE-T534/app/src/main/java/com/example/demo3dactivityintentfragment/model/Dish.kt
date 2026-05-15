package com.example.demo3dactivityintentfragment.model
import com.example.demo3dactivityintentfragment.data.allCountries
import android.os.Parcelable
import com.example.demo3dactivityintentfragment.enums.DishType
import com.example.demo3dactivityintentfragment.enums.SpiceLevel
import java.util.UUID
import kotlinx.parcelize.Parcelize
import java.net.URL

@Parcelize
data class Dish(
    val id: UUID,
    val name: String,
    val countryID: UUID,        // links to Country.id in CountryData.kt
    val emoji: String,
    val type: DishType,
    val spiceLevel: SpiceLevel,
    val description: String,
    val rating: Double,         // 1.0 – 5.0
    val calories: Int,          // kcal per serving
    val color: Int,
    val url: String
): Parcelable {
    /// Resolves the Country object from CountryData
    val country: Country?
        get() = allCountries.firstOrNull { it.id == countryID }
}