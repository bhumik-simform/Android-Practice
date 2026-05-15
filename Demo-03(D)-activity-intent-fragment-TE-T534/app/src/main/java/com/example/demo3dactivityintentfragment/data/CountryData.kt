package com.example.demo3dactivityintentfragment.data

import android.graphics.Color
import com.example.demo3dactivityintentfragment.model.Country

val allCountries = listOf(

    Country(
        id = idChina,
        name = "China",
        flagEmoji = "🇨🇳",
        bgColor = Color.argb(
            204,
            (0.83 * 255).toInt(),
            (0.18 * 255).toInt(),
            (0.18 * 255).toInt()
        ),
        cuisineStyle = "Diverse & Complex",
        description = "Chinese cuisine spans eight major regional styles, each with distinct ingredients and methods. From the fiery heat of Sichuan to the light steamed dishes of Cantonese cooking, it offers extraordinary variety."
    ),

    Country(
        id = idFrance,
        name = "France",
        flagEmoji = "🇫🇷",
        bgColor = Color.argb(
            204,
            (0.20 * 255).toInt(),
            (0.40 * 255).toInt(),
            (0.73 * 255).toInt()
        ),
        cuisineStyle = "Refined & Classic",
        description = "French cuisine is the foundation of modern Western cooking. Known for its sauces, pastries, and meticulous technique, it has shaped professional kitchens and fine dining around the globe."
    ),

    Country(
        id = idGreece,
        name = "Greece",
        flagEmoji = "🇬🇷",
        bgColor = Color.argb(
            204,
            (0.18 * 255).toInt(),
            (0.55 * 255).toInt(),
            (0.84 * 255).toInt()
        ),
        cuisineStyle = "Fresh & Mediterranean",
        description = "Greek cuisine celebrates the Mediterranean diet — olive oil, fresh vegetables, legumes, and seafood. Simple preparations that let quality ingredients shine are the hallmark of this ancient culinary tradition."
    ),

    Country(
        id = idIndia,
        name = "India",
        flagEmoji = "🇮🇳",
        bgColor = Color.argb(
            204,
            (0.90 * 255).toInt(),
            (0.49 * 255).toInt(),
            (0.13 * 255).toInt()
        ),
        cuisineStyle = "Spicy & Aromatic",
        description = "Indian cuisine is a vibrant tapestry of spices, herbs, and regional diversity. From creamy curries of the north to tangy coconut-based dishes of the south, every state offers a distinct flavour palette."
    ),

    Country(
        id = idItaly,
        name = "Italy",
        flagEmoji = "🇮🇹",
        bgColor = Color.argb(
            204,
            (0.91 * 255).toInt(),
            (0.30 * 255).toInt(),
            (0.24 * 255).toInt()
        ),
        cuisineStyle = "Rich & Hearty",
        description = "Italian cuisine is rooted in fresh, high-quality ingredients and regional traditions. Pasta, pizza, and slow-cooked sauces form the backbone of a culinary culture loved worldwide."
    ),

    Country(
        id = idJapan,
        name = "Japan",
        flagEmoji = "🇯🇵",
        bgColor = Color.argb(
            204,
            (0.75 * 255).toInt(),
            (0.22 * 255).toInt(),
            (0.17 * 255).toInt()
        ),
        cuisineStyle = "Umami & Delicate",
        description = "Japanese cuisine emphasises seasonal ingredients, precise technique, and a balance of five flavours. From the simplicity of miso soup to the artistry of sushi, every dish tells a story of craftsmanship."
    ),

    Country(
        id = idMexico,
        name = "Mexico",
        flagEmoji = "🇲🇽",
        bgColor = Color.argb(
            204,
            (0.15 * 255).toInt(),
            (0.68 * 255).toInt(),
            (0.38 * 255).toInt()
        ),
        cuisineStyle = "Bold & Fiery",
        description = "Mexican cuisine blends indigenous Aztec and Maya ingredients with Spanish influences. Corn, chilli, and chocolate form its ancient trinity, giving rise to a complex and satisfying food culture."
    ),

    Country(
        id = idSpain,
        name = "Spain",
        flagEmoji = "🇪🇸",
        bgColor = Color.argb(
            204,
            (0.83 * 255).toInt(),
            (0.33 * 255).toInt(),
            (0.00 * 255).toInt()
        ),
        cuisineStyle = "Tapas & Saffron",
        description = "Spanish cuisine is built around communal eating, olive oil, and bold flavours. Tapas culture, saffron-scented paella, and a rich tradition of cured meats make it one of Europe's most celebrated food cultures."
    ),

    Country(
        id = idThailand,
        name = "Thailand",
        flagEmoji = "🇹🇭",
        bgColor = Color.argb(
            204,
            (0.61 * 255).toInt(),
            (0.15 * 255).toInt(),
            (0.69 * 255).toInt()
        ),
        cuisineStyle = "Sweet, Sour & Spicy",
        description = "Thai cuisine achieves a careful balance of sweet, sour, salty, and spicy in every dish. Fresh herbs like lemongrass, galangal, and kaffir lime leave a distinctly aromatic impression."
    ),

    Country(
        id = idUSA,
        name = "USA",
        flagEmoji = "🇺🇸",
        bgColor = Color.argb(
            204,
            (0.18 * 255).toInt(),
            (0.32 * 255).toInt(),
            (0.57 * 255).toInt()
        ),
        cuisineStyle = "Comfort & Bold",
        description = "American cuisine is a melting pot of immigrant traditions and regional identities. From Southern BBQ to New England chowder, it reflects the country's diverse cultural heritage in every bite."
    )

).sortedBy { it.name }