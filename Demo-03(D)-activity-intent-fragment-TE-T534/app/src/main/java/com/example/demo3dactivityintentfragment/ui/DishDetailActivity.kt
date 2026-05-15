package com.example.demo3dactivityintentfragment.ui

import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.demo3dactivityintentfragment.R
import com.example.demo3dactivityintentfragment.model.Dish
import androidx.core.net.toUri

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
class DishDetailActivity : AppCompatActivity() {

    private lateinit var dishEmojiCardView: CardView
    private lateinit var dishEmojiTextView: TextView
    private lateinit var dishNameTextView: TextView
    private lateinit var dishCountryTextView: TextView
    private lateinit var dishTypeTextView: TextView
    private lateinit var dishSpiceLevelTextView: TextView
    private lateinit var dishCaloriesTextView: TextView
    private lateinit var dishRatingTextView: TextView
    private lateinit var dishDescriptionTextView: TextView

    private lateinit var dishKnowMoreTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dish_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()
    }

    private fun setupUI() {
        dishEmojiCardView = findViewById(R.id.cv_dish_emoji)
        dishEmojiTextView = findViewById(R.id.tv_dish_emoji)
        dishNameTextView = findViewById(R.id.tv_dish_name)
        dishCountryTextView = findViewById(R.id.tv_dish_country)
        dishTypeTextView = findViewById(R.id.tv_dish_type)
        dishSpiceLevelTextView = findViewById(R.id.tv_dish_spice_level)
        dishCaloriesTextView = findViewById(R.id.tv_calories_value)
        dishRatingTextView = findViewById(R.id.tv_rating_value)
        dishDescriptionTextView = findViewById(R.id.tv_dish_description)
        dishKnowMoreTextView = findViewById(R.id.tv_know_more)

        inflateData()
    }

    private fun inflateData() {
        val dish =  intent.getParcelableExtra("Dish_Parcel", Dish::class.java)
        if(dish != null) {
            dishEmojiCardView.setCardBackgroundColor(dish.color)
            dishEmojiTextView.text = dish.emoji
            dishNameTextView.text = dish.name
            dishCountryTextView.text = dish.country?.name
            dishTypeTextView.text = dish.type.displayName
            dishTypeTextView.setTextColor(dish.type.colorCode())
            dishTypeTextView.backgroundTintList = ColorStateList.valueOf(ColorUtils.setAlphaComponent(dish.type.colorCode(), 127))
            dishSpiceLevelTextView.text = dish.spiceLevel.label
            dishSpiceLevelTextView.setTextColor(dish.spiceLevel.badgeColor())
            dishSpiceLevelTextView.backgroundTintList = ColorStateList.valueOf(ColorUtils.setAlphaComponent(dish.spiceLevel.badgeColor(), 127))
            dishCaloriesTextView.text = dish.calories.toString()
            dishRatingTextView.text = dish.rating.toString()
            dishDescriptionTextView.text = dish.description
            dishKnowMoreTextView.text = applyClickableLink(dish.url)
            dishKnowMoreTextView.movementMethod = LinkMovementMethod.getInstance()
        }
    }

    private fun applyClickableLink(url: String): SpannableString {
        val spannableStringLink =  SpannableString("know more")

        val clickableSpan = object: ClickableSpan() {
            override fun onClick(p0: View) {
                val webIntent = Intent(Intent.ACTION_VIEW, url.toUri())
                startActivity(webIntent)
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }

        spannableStringLink.setSpan(clickableSpan,0,spannableStringLink.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        return spannableStringLink
    }

}