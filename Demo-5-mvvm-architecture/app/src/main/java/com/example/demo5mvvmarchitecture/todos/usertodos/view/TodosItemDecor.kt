package com.example.demo5mvvmarchitecture.todos.usertodos.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class TodosItemDecor(private val spacing: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = spacing
        outRect.right = spacing
        outRect.bottom = spacing

        if(parent.getChildAdapterPosition(view)==0) { // This condition becomes true for first item of the recycler view
            outRect.top = spacing // Provide spacial top spacing for of first item of recycler view
        }
    }
}