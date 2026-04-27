package com.example.pixelsettings

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacingSectioningDecoration: RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.left = 56
        outRect.right = 56

        val currPosition = parent.getChildAdapterPosition(view)
        val currItem = settingList.elementAt(currPosition)

        if(currPosition == 0) {
            outRect.top = 0
        } else if (currItem.itemType == ItemType.TOP) {
            outRect.top = 32
        } else {
            outRect.top = 8
        }

    }
}