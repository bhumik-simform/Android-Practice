package com.example.demo3dactivityintentfragment.adapater

import android.content.res.ColorStateList
import com.example.demo3dactivityintentfragment.model.Dish
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.demo3dactivityintentfragment.R

class DishAdapter(private val dishData: List<Dish>, private val onItemClick: (Dish) -> Unit) :
    RecyclerView.Adapter<DishAdapter.DishItemViewHolder>() {

    class DishItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val dishEmojiCardView: CardView = view.findViewById(R.id.cv_dish_emoji)
        private val dishEmojiTextView: TextView = view.findViewById(R.id.tv_dish_emoji)
        private val dishNameTextView: TextView = view.findViewById(R.id.tv_dish_name)
        private val dishCountryTextView: TextView = view.findViewById(R.id.tv_dish_country)
        private val dishTypeMarkView: View = view.findViewById(R.id.view_dish_type_mark)
        private val dishTypeTextView: TextView = view.findViewById(R.id.tv_dish_type)
        private val dishSpiceLevelTextView: TextView = view.findViewById(R.id.tv_dish_spice_level)

        fun bindData(dish: Dish) {
            dishEmojiCardView.setCardBackgroundColor(dish.color)
            dishEmojiTextView.text = dish.emoji
            dishNameTextView.text = dish.name
            dishCountryTextView.text = dish.country?.name
            dishTypeMarkView.backgroundTintList = ColorStateList.valueOf(dish.type.colorCode())
            dishTypeTextView.text = dish.type.displayName
            dishSpiceLevelTextView.text = dish.spiceLevel.label
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DishItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishItemViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: DishItemViewHolder,
        position: Int
    ) {
        val currDish = dishData.elementAt(position)
        holder.bindData(currDish)
        holder.itemView.setOnClickListener { onItemClick(currDish) }
    }

    override fun getItemCount() = dishData.count()


}