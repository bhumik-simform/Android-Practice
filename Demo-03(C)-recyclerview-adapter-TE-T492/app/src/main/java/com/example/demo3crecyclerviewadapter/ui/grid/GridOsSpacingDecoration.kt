package com.example.demo3crecyclerviewadapter.ui.grid

import android.graphics.Rect
import android.view.View
import androidx.core.graphics.component2
import androidx.recyclerview.widget.RecyclerView

class GridOsSpacingDecoration(val spanCount: Int, val spacing: Int = 16) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount
        val row = position / spanCount
        val lastRow = (state.itemCount - 1) / spanCount

        outRect.left = spacing - (column * spacing / spanCount)
        outRect.right = (column + 1) * spacing / spanCount

        outRect.top = spacing / 2
        outRect.bottom = 0

        when(row) {
            0 -> outRect.top = spacing
            lastRow -> spacing
        }

    }

}