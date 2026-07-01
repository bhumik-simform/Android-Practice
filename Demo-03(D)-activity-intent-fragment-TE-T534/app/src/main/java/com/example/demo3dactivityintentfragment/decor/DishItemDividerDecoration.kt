package com.example.demo3dactivityintentfragment.decor

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class DishItemDividerDecoration: RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val paint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 2f
        }

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)

            val left = (child.left - 8).toFloat()
            val right = (child.right - 8).toFloat()
            val  top = child.top.toFloat()

            c.drawLine(left, top, right,top, paint)
        }
    }
}