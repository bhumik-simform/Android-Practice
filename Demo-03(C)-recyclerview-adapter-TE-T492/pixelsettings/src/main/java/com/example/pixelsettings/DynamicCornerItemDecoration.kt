package com.example.pixelsettings

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class DynamicCornerItemDecoration(private val context: Context) : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)




        for (i in 0 until parent.childCount) {

            val currChildView = parent.getChildAt(i)

            val position = parent.getChildAdapterPosition(currChildView)

            val currChildItem = settingList.elementAt(position)

            val backGroundShape = if (position == 0 && currChildItem.itemType == ItemType.TOP) {
                ContextCompat.getDrawable(context, R.drawable.bg_single_child)
            } else {
                when (currChildItem.itemType) {
                    ItemType.TOP -> ContextCompat.getDrawable(
                        context,
                        R.drawable.bg_top_child
                    )

                    ItemType.MIDDLE -> ContextCompat.getDrawable(
                        context,
                        R.drawable.bg_middle_child
                    )

                    ItemType.BOTTOM -> ContextCompat.getDrawable(
                        context,
                        R.drawable.bg_bottom_child
                    )
                }
            }


            val left = currChildView.left
            val right = currChildView.right
            val top = currChildView.top
            val bottom = currChildView.bottom
            backGroundShape.let {
                it?.setBounds(left, top, right, bottom)
                it?.draw(c)
            }
        }
    }
}