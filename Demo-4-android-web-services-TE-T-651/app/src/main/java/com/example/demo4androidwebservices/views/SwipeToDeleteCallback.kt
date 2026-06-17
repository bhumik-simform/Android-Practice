package com.example.demo4androidwebservices.views

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.SimpleCallback
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.listitem.ListItemCardView

object SwipeToDeleteCallback {
    fun addGesture(rv: RecyclerView, action: (Int)-> Unit ) {
        val helper = ItemTouchHelper( object : SimpleCallback( 0, ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(
                viewHolder: RecyclerView.ViewHolder,
                direction: Int
            ) {
                val position = viewHolder.absoluteAdapterPosition
                action(position)
            }
        })
        helper.attachToRecyclerView(rv)
    }
}