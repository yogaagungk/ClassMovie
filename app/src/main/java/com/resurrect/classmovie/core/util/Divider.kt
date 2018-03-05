package com.resurrect.classmovie.core.util

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import com.resurrect.classmovie.R

/**
 * Created by yogaagungk on 11/02/18.
 */
class Divider(context: Context) : RecyclerView.ItemDecoration() {
    private var divider : Drawable? = null

    init {
        divider = ContextCompat.getDrawable(context, R.drawable.line_divider)
    }

    override fun onDrawOver(c: Canvas?, parent: RecyclerView?, state: RecyclerView.State?) {
        var left = parent?.paddingLeft as Int
        var right = parent.width - parent.paddingRight

        var childCount = parent.childCount

        for (i in 0 until childCount){
            val child = parent.getChildAt(i)

            val params : RecyclerView.LayoutParams = child.layoutParams as RecyclerView.LayoutParams

            val top = child.bottom + params.bottomMargin
            val bottom = top + divider!!.intrinsicHeight

            divider!!.setBounds(left, top, right, bottom)
            divider!!.draw(c)
        }

    }
}