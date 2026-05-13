package com.example.demo3dactivityintentfragment.data

import com.example.demo3dactivityintentfragment.model.Dish
import android.graphics.Color
import com.example.demo3dactivityintentfragment.enums.DishType
import com.example.demo3dactivityintentfragment.enums.SpiceLevel
import java.util.UUID

val allDishes: List<Dish> = listOf(

    // MARK: China
    Dish(
        id = UUID.randomUUID(), name = "Dim Sum",
        countryID = idChina, emoji = "🥟", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "A variety of small bite-sized dishes — dumplings, buns, rolls, and cakes — served in bamboo steamers during the Cantonese yum cha tradition.",
        rating = 4.7, calories = 290,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.87 * 255).toInt(), (0.84 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Fried Rice",
        countryID = idChina, emoji = "🍳", type = DishType.VEG, spiceLevel = SpiceLevel.MILD,
        description = "Day-old rice wok-tossed over intense heat with eggs, soy sauce, spring onions, and vegetables. The hallmark of 'wok hei' — the smoky breath of the wok.",
        rating = 4.5, calories = 340,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.95 * 255).toInt(), (0.80 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Kung Pao Chicken",
        countryID = idChina, emoji = "🍗", type = DishType.NON_VEG, spiceLevel = SpiceLevel.SPICY,
        description = "A Sichuan stir-fry of diced chicken with dried chillies, Sichuan peppercorns, peanuts, and spring onions. Named after a Qing Dynasty official.",
        rating = 4.7, calories = 430,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.80 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Mapo Tofu",
        countryID = idChina, emoji = "🍲", type = DishType.VEGAN, spiceLevel = SpiceLevel.EXTRA_HOT,
        description = "Silken tofu in a fiery Sichuan sauce of fermented black beans, doubanjiang chilli paste, and numbing Sichuan peppercorns. A vegetarian dish with maximum impact.",
        rating = 4.6, calories = 260,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.82 * 255).toInt(), (0.76 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Peking Duck",
        countryID = idChina, emoji = "🦆", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Whole duck air-dried and roasted for lacquered, mahogany skin. Served with thin pancakes, spring onions, cucumber, and hoisin sauce. A Beijing imperial dish.",
        rating = 4.8, calories = 540,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.84 * 255).toInt(), (0.80 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Spring Rolls",
        countryID = idChina, emoji = "🌯", type = DishType.VEG, spiceLevel = SpiceLevel.MILD,
        description = "Crispy fried rolls stuffed with seasoned vegetables and glass noodles. A Chinese New Year staple whose golden colour symbolises prosperity.",
        rating = 4.4, calories = 220,
        color = Color.argb(255, (0.93 * 255).toInt(), (0.96 * 255).toInt(), (0.80 * 255).toInt())
    ),

    // MARK: France
    Dish(
        id = UUID.randomUUID(), name = "Baguette",
        countryID = idFrance, emoji = "🥖", type = DishType.VEGAN, spiceLevel = SpiceLevel.NONE,
        description = "France's iconic long bread with a crunchy golden crust and an open, chewy crumb. Made from just flour, water, salt, and yeast — recognised by UNESCO as cultural heritage.",
        rating = 4.6, calories = 200,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.93 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Coq au Vin",
        countryID = idFrance, emoji = "🍗", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Chicken braised slowly in red wine with lardons, mushrooms, and pearl onions. A French farmhouse dish that showcases the magic of low-and-slow cooking.",
        rating = 4.6, calories = 480,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.82 * 255).toInt(), (0.93 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Crème Brûlée",
        countryID = idFrance, emoji = "🍮", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "A silky vanilla custard baked in a water bath and finished with a crisp caramelised sugar shell. The contrast of cool cream and hot toffee is the whole point.",
        rating = 4.8, calories = 310,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.96 * 255).toInt(), (0.82 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Croissant",
        countryID = idFrance, emoji = "🥐", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "A flaky, buttery viennoiserie made from laminated dough. Achieving the perfect croissant requires 27 alternating layers of butter and dough and three days of patience.",
        rating = 4.7, calories = 231,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.95 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "French Onion Soup",
        countryID = idFrance, emoji = "🍲", type = DishType.VEG, spiceLevel = SpiceLevel.MILD,
        description = "Caramelised onions simmered in beef stock, topped with crusty bread and melted Gruyère. A Parisian bistro classic that takes hours to do properly.",
        rating = 4.5, calories = 360,
        color = Color.argb(255, (0.96 * 255).toInt(), (0.91 * 255).toInt(), (0.80 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Ratatouille",
        countryID = idFrance, emoji = "🍆", type = DishType.VEGAN, spiceLevel = SpiceLevel.MILD,
        description = "A Provençal vegetable stew of aubergine, courgette, peppers, tomato, and herbs. Slow-cooked to concentrate flavour — a summer garden in a pot.",
        rating = 4.4, calories = 180,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.87 * 255).toInt(), (0.96 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Baklava",
        countryID = idGreece, emoji = "🍯", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Layers of phyllo dough filled with chopped pistachios and walnuts, baked until crisp and drenched in honey syrup. Sweet, flaky, and deeply satisfying.",
        rating = 4.8, calories = 430,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.93 * 255).toInt(), (0.76 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Greek Salad",
        countryID = idGreece, emoji = "🥗", type = DishType.VEGAN, spiceLevel = SpiceLevel.NONE,
        description = "Chunky tomatoes, cucumber, red onion, and Kalamata olives dressed in olive oil and oregano, topped with a thick slab of feta. The taste of the Aegean.",
        rating = 4.5, calories = 210,
        color = Color.argb(255, (0.80 * 255).toInt(), (0.93 * 255).toInt(), (0.87 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Moussaka",
        countryID = idGreece, emoji = "🥘", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Layers of sliced aubergine, spiced minced lamb, and béchamel sauce baked until golden. Greece's answer to lasagne — a dish of warmth and heritage.",
        rating = 4.6, calories = 500,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.91 * 255).toInt(), (0.98 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Souvlaki",
        countryID = idGreece, emoji = "🍢", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Marinated pork or chicken threaded on skewers and grilled over charcoal. Served with pita, tzatziki, and tomato — Greece's ultimate fast food.",
        rating = 4.7, calories = 390,
        color = Color.argb(255, (0.87 * 255).toInt(), (0.93 * 255).toInt(), (0.98 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Spanakopita",
        countryID = idGreece, emoji = "🥧", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "A savoury phyllo pastry pie filled with spinach, feta cheese, onions, and eggs. Layers of paper-thin dough brushed with olive oil create an irresistible crunch.",
        rating = 4.4, calories = 350,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.96 * 255).toInt(), (0.89 * 255).toInt())
    ),


    // MARK: India
    Dish(
        id = UUID.randomUUID(), name = "Biryani",
        countryID = idIndia, emoji = "🍛", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MEDIUM,
        description = "Fragrant basmati rice layered with marinated meat or vegetables, slow-cooked in a sealed pot with saffron, spices, and fried onions. A dish of royal Mughal heritage.",
        rating = 4.9, calories = 490,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.95 * 255).toInt(), (0.76 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Butter Chicken",
        countryID = idIndia, emoji = "🍗", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Tandoori chicken simmered in a creamy, mildly spiced tomato and butter sauce. A Delhi classic that conquered the world's curry houses.",
        rating = 4.8, calories = 520,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.84 * 255).toInt(), (0.76 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Dosa",
        countryID = idIndia, emoji = "🥞", type = DishType.VEGAN, spiceLevel = SpiceLevel.MILD,
        description = "A crispy South Indian crêpe made from fermented rice and lentil batter, served with coconut chutney and sambar. A breakfast staple across southern India.",
        rating = 4.7, calories = 180,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.96 * 255).toInt(), (0.84 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Paneer Tikka",
        countryID = idIndia, emoji = "🧀", type = DishType.VEG, spiceLevel = SpiceLevel.MEDIUM,
        description = "Marinated cottage cheese cubes skewered with peppers and onions, grilled in a tandoor oven. A vegetarian favourite from Punjab.",
        rating = 4.6, calories = 320,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.93 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Samosa",
        countryID = idIndia, emoji = "🥟", type = DishType.VEG, spiceLevel = SpiceLevel.MILD,
        description = "Crispy fried pastry triangles filled with spiced potatoes, peas, and sometimes meat. An iconic street snack enjoyed throughout India and beyond.",
        rating = 4.5, calories = 260,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.93 * 255).toInt(), (0.76 * 255).toInt())
    ),

    // MARK: Italy
    Dish(
        id = UUID.randomUUID(), name = "Carbonara",
        countryID = idItaly, emoji = "🍝", type = DishType.NON_VEG, spiceLevel = SpiceLevel.NONE,
        description = "Roman pasta with guanciale (cured pork cheek), eggs, Pecorino Romano, and black pepper. Silky, porky, and deceptively simple — no cream needed.",
        rating = 4.8, calories = 570,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.96 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Gelato",
        countryID = idItaly, emoji = "🍨", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Italian-style ice cream churned at a slower speed for a denser, more intense flavour. Artisanal gelato is made fresh daily with natural ingredients.",
        rating = 4.7, calories = 240,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.91 * 255).toInt(), (0.93 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Margherita Pizza",
        countryID = idItaly, emoji = "🍕", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Naples' gift to the world: chewy dough topped with San Marzano tomatoes, mozzarella di bufala, and fresh basil. Named after Italy's Queen Margherita in 1889.",
        rating = 4.9, calories = 280,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.91 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Risotto",
        countryID = idItaly, emoji = "🍚", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Creamy Arborio rice stirred constantly with hot stock, finished with butter and Parmigiano-Reggiano. A Northern Italian dish that requires patience and good stirring technique.",
        rating = 4.6, calories = 380,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.98 * 255).toInt(), (0.84 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Tiramisu",
        countryID = idItaly, emoji = "🍰", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Layers of espresso-soaked ladyfingers, mascarpone cream, and cocoa powder. The name translates to 'pick-me-up' — a reference to the coffee and sugar rush.",
        rating = 4.8, calories = 450,
        color = Color.argb(255, (0.93 * 255).toInt(), (0.89 * 255).toInt(), (0.82 * 255).toInt())
    ),

    // MARK: Japan
    Dish(
        id = UUID.randomUUID(), name = "Ramen",
        countryID = idJapan, emoji = "🍜", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Wheat noodles in a rich broth (shoyu, miso, tonkotsu, or shio) with toppings like chashu pork, soft-boiled eggs, and nori. Japan's ultimate comfort food.",
        rating = 4.9, calories = 450,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.96 * 255).toInt(), (0.87 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Sushi",
        countryID = idJapan, emoji = "🍣", type = DishType.NON_VEG, spiceLevel = SpiceLevel.NONE,
        description = "Vinegared rice topped with fresh raw fish or seafood. An art form as much as a meal — precision, freshness, and seasonality are everything.",
        rating = 4.9, calories = 280,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.87 * 255).toInt(), (0.91 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Takoyaki",
        countryID = idJapan, emoji = "🐙", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "Crispy-on-the-outside, molten-inside octopus balls drizzled with takoyaki sauce, mayo, and bonito flakes. An Osaka street-food icon.",
        rating = 4.5, calories = 320,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.91 * 255).toInt(), (0.84 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Tempura",
        countryID = idJapan, emoji = "🍤", type = DishType.NON_VEG, spiceLevel = SpiceLevel.NONE,
        description = "Seafood and vegetables dipped in a light batter and flash-fried. Introduced by Portuguese traders in the 16th century, perfected by Japanese chefs.",
        rating = 4.6, calories = 340,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.98 * 255).toInt(), (0.87 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Tonkatsu",
        countryID = idJapan, emoji = "🍖", type = DishType.NON_VEG, spiceLevel = SpiceLevel.NONE,
        description = "Breaded, deep-fried pork cutlet served with shredded cabbage and a sweet-savoury sauce. Crispy on the outside, juicy inside — a Japanese comfort classic.",
        rating = 4.7, calories = 520,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.93 * 255).toInt(), (0.82 * 255).toInt())
    ),

    // MARK: Mexico
    Dish(
        id = UUID.randomUUID(), name = "Chilaquiles",
        countryID = idMexico, emoji = "🌮", type = DishType.VEG, spiceLevel = SpiceLevel.MEDIUM,
        description = "Crispy tortilla chips simmered in green or red salsa, topped with crema, cheese, onion, and sometimes eggs. The ultimate Mexican breakfast or brunch dish.",
        rating = 4.5, calories = 380,
        color = Color.argb(255, (0.87 * 255).toInt(), (0.96 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Churros",
        countryID = idMexico, emoji = "🍩", type = DishType.VEGAN, spiceLevel = SpiceLevel.NONE,
        description = "Ridged fried dough dusted with cinnamon sugar. Originally Spanish, but perfected as a sweet street snack in Mexico and Latin America.",
        rating = 4.6, calories = 310,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.93 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Enchiladas",
        countryID = idMexico, emoji = "🫔", type = DishType.NON_VEG, spiceLevel = SpiceLevel.SPICY,
        description = "Corn tortillas filled with meat and cheese, rolled up and smothered in a deep red chilli sauce. Baked and topped with sour cream and fresh cheese.",
        rating = 4.5, calories = 440,
        color = Color.argb(255, (0.91 * 255).toInt(), (0.96 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Guacamole",
        countryID = idMexico, emoji = "🥑", type = DishType.VEGAN, spiceLevel = SpiceLevel.MILD,
        description = "Mashed ripe avocados with lime juice, salt, coriander, and jalapeño. An ancient Aztec preparation that has become one of the world's favourite dips.",
        rating = 4.6, calories = 150,
        color = Color.argb(255, (0.78 * 255).toInt(), (0.93 * 255).toInt(), (0.73 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Pozole",
        countryID = idMexico, emoji = "🍲", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MEDIUM,
        description = "A hearty hominy corn and pork soup with a rich broth, garnished with shredded cabbage, radish, oregano, and lime. A pre-Columbian ceremonial dish.",
        rating = 4.4, calories = 420,
        color = Color.argb(255, (0.87 * 255).toInt(), (0.96 * 255).toInt(), (0.84 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Quesadilla",
        countryID = idMexico, emoji = "🧇", type = DishType.VEG, spiceLevel = SpiceLevel.MILD,
        description = "A flour tortilla filled with melted cheese, griddled until crispy. Often upgraded with grilled vegetables, mushrooms, or huitlacoche (corn truffle).",
        rating = 4.3, calories = 380,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.96 * 255).toInt(), (0.80 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Tacos al Pastor",
        countryID = idMexico, emoji = "🌮", type = DishType.NON_VEG, spiceLevel = SpiceLevel.SPICY,
        description = "Marinated pork cooked on a vertical spit, served in small corn tortillas with pineapple, onion, and cilantro. Street food at its most glorious.",
        rating = 4.9, calories = 370,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.96 * 255).toInt(), (0.82 * 255).toInt())
    ),

    // MARK: Spain
    Dish(
        id = UUID.randomUUID(), name = "Churros Chocolate",
        countryID = idSpain, emoji = "🍫", type = DishType.VEGAN, spiceLevel = SpiceLevel.NONE,
        description = "Thick, ridged churros fried to order and served with a cup of dense, dark drinking chocolate — a Spanish breakfast or late-night staple enjoyed for centuries.",
        rating = 4.7, calories = 420,
        color = Color.argb(255, (0.87 * 255).toInt(), (0.78 * 255).toInt(), (0.71 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Gazpacho",
        countryID = idSpain, emoji = "🍅", type = DishType.VEGAN, spiceLevel = SpiceLevel.MILD,
        description = "A chilled Andalusian soup blended from raw tomatoes, cucumber, peppers, garlic, olive oil, and sherry vinegar. Refreshing, bright, and beautiful in its simplicity.",
        rating = 4.4, calories = 130,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.84 * 255).toInt(), (0.78 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Paella",
        countryID = idSpain, emoji = "🥘", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "A Valencian rice dish cooked in a wide flat pan with saffron, seafood or rabbit, green beans, and rosemary. The socarrat — toasted rice crust at the bottom — is the prize.",
        rating = 4.8, calories = 520,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.91 * 255).toInt(), (0.71 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Patatas Bravas",
        countryID = idSpain, emoji = "🥔", type = DishType.VEGAN, spiceLevel = SpiceLevel.SPICY,
        description = "Crispy fried potato cubes served with a spicy tomato-paprika sauce and creamy alioli. The defining tapa of Madrid's bar culture.",
        rating = 4.4, calories = 310,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.93 * 255).toInt(), (0.73 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Tortilla Española",
        countryID = idSpain, emoji = "🍳", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "A thick potato and egg omelette cooked slowly in olive oil. Served at room temperature, it is the most democratic dish in Spain — found from tapas bars to home kitchens.",
        rating = 4.6, calories = 300,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.96 * 255).toInt(), (0.80 * 255).toInt())
    ),

    // MARK: Thailand
    Dish(
        id = UUID.randomUUID(), name = "Green Curry",
        countryID = idThailand, emoji = "🍛", type = DishType.NON_VEG, spiceLevel = SpiceLevel.SPICY,
        description = "A fragrant coconut milk curry made with green chilli paste, galangal, and kaffir lime. The balance of heat, creaminess, and citrus is uniquely Thai.",
        rating = 4.7, calories = 420,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.96 * 255).toInt(), (0.84 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Mango Sticky Rice",
        countryID = idThailand, emoji = "🥭", type = DishType.VEGAN, spiceLevel = SpiceLevel.NONE,
        description = "Sweet glutinous rice cooked in coconut milk, served with ripe sliced mango and a drizzle of salted coconut cream. Thailand's most beloved dessert.",
        rating = 4.8, calories = 360,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.96 * 255).toInt(), (0.76 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Pad Thai",
        countryID = idThailand, emoji = "🍜", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MEDIUM,
        description = "Stir-fried rice noodles with shrimp or chicken, eggs, bean sprouts, and spring onions, tossed in tamarind sauce and topped with crushed peanuts.",
        rating = 4.8, calories = 490,
        color = Color.argb(255, (0.93 * 255).toInt(), (0.84 * 255).toInt(), (0.98 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Som Tum",
        countryID = idThailand, emoji = "🥗", type = DishType.VEGAN, spiceLevel = SpiceLevel.SPICY,
        description = "Green papaya shredded and pounded in a mortar with chilli, lime, garlic, fish sauce, and palm sugar. A fiery, crunchy, refreshing salad from northeast Thailand.",
        rating = 4.5, calories = 130,
        color = Color.argb(255, (0.87 * 255).toInt(), (0.96 * 255).toInt(), (0.80 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Tom Yum Soup",
        countryID = idThailand, emoji = "🍲", type = DishType.NON_VEG, spiceLevel = SpiceLevel.EXTRA_HOT,
        description = "A hot and sour broth with lemongrass, kaffir lime leaves, galangal, and chilli, loaded with prawns or chicken and mushrooms. Intensely aromatic.",
        rating = 4.7, calories = 200,
        color = Color.argb(255, (0.98 * 255).toInt(), (0.82 * 255).toInt(), (0.93 * 255).toInt())
    ),

    // MARK: USA
    Dish(
        id = UUID.randomUUID(), name = "BBQ Ribs",
        countryID = idUSA, emoji = "🍖", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MEDIUM,
        description = "Pork spare ribs slow-smoked for hours over hickory or applewood, glazed in a tangy barbecue sauce. The centrepiece of Southern American pit culture.",
        rating = 4.8, calories = 680,
        color = Color.argb(255, (0.87 * 255).toInt(), (0.84 * 255).toInt(), (0.96 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Caesar Salad",
        countryID = idUSA, emoji = "🥗", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Crispy romaine lettuce tossed in a creamy dressing of anchovies, egg yolk, lemon, Worcestershire, and Parmesan, topped with garlic croutons.",
        rating = 4.4, calories = 280,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.96 * 255).toInt(), (0.87 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Cheeseburger",
        countryID = idUSA, emoji = "🍔", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "A griddled beef patty with American cheese, lettuce, tomato, pickles, and condiments in a brioche bun. The quintessential American comfort food.",
        rating = 4.5, calories = 560,
        color = Color.argb(255, (0.84 * 255).toInt(), (0.89 * 255).toInt(), (0.98 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Clam Chowder",
        countryID = idUSA, emoji = "🍵", type = DishType.NON_VEG, spiceLevel = SpiceLevel.MILD,
        description = "A creamy New England soup thick with clams, potatoes, bacon, and onions. Traditionally served in a hollowed sourdough bread bowl on Fisherman's Wharf.",
        rating = 4.5, calories = 390,
        color = Color.argb(255, (0.89 * 255).toInt(), (0.93 * 255).toInt(), (0.98 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Mac and Cheese",
        countryID = idUSA, emoji = "🧀", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Elbow macaroni in a creamy cheddar béchamel, baked with a golden breadcrumb topping. A dish traced back to Thomas Jefferson, now America's ultimate comfort food.",
        rating = 4.6, calories = 490,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.95 * 255).toInt(), (0.76 * 255).toInt())
    ),

    Dish(
        id = UUID.randomUUID(), name = "Pancakes",
        countryID = idUSA, emoji = "🥞", type = DishType.VEG, spiceLevel = SpiceLevel.NONE,
        description = "Fluffy stacked pancakes served with maple syrup and butter. The weekend-morning ritual of millions of American households — simple, golden perfection.",
        rating = 4.6, calories = 350,
        color = Color.argb(255, (1.00 * 255).toInt(), (0.93 * 255).toInt(), (0.82 * 255).toInt())
    )

).sortedBy { it.name }