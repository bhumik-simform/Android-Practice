package com.example.demo3crecyclerviewadapter.ui.grid

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridOsSpacingDecoration: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val spacing = 100
        outRect.top = 16
//        outRect.bottom = spacing
        outRect.left = spacing
//        outRect.right = spacing
    }

}