package com.alwan.barangku.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0)
                top = spaceHeight * 2
            left = spaceHeight
            right = spaceHeight
            bottom =
                if (parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(1))
                    spaceHeight * 2
                else
                    spaceHeight
        }
    }
}