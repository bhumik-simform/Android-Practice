package com.example.demo3crecyclerviewadapter.recycler

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView

class DividerDecoration: RecyclerView.ItemDecoration() {
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val paint = Paint()
        paint.color = Color.BLACK
        paint.strokeWidth = 2f

        val childCount = parent.childCount
        for (i in 0 until childCount-1) {
            val child = parent.getChildAt(i)

            val left = child.left.toFloat() // also for design write here parent.leftPadding difference in this UI none
            val right = child.right.toFloat() // also for design write here parent.width - parent.rightPadding  difference om this UI none
            val bottom = child.bottom.toFloat()

            c.drawLine(left,bottom,right,bottom,paint)
        }
    }
}