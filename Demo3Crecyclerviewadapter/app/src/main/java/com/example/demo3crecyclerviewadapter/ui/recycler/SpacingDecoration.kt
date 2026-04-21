package com.example.demo3crecyclerviewadapter.ui.recycler

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingDecoration(val spacing: Int): RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = 16
        outRect.left = 16

        val position = parent.getChildAdapterPosition(view)
        val lastPosition = (parent.adapter?.itemCount ?: 0) - 1

        outRect.top = when (position) {
            0->16
            else -> spacing
        }
        if(position==lastPosition) {
            outRect.bottom = 16
        }
    }
}