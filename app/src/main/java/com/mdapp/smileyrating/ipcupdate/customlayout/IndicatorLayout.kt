package com.mdapp.smileyrating.ipcupdate.customlayout

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup

import android.widget.LinearLayout
import com.mdapp.smileyrating.R

class IndicatorLayout: LinearLayout {
    
    private var indicatorCount: Int = 0
    private var selectedPosition: Int = 0
    
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet): super(context, attrs){
        indicatorCount(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int): super(context, attrs, defStyleAttr){
        indicatorCount(context, attrs, defStyleAttr)
    }

    private fun indicatorCount(context: Context, attrs: AttributeSet, defStyleAttr: Int) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.IndicatorLayout, defStyleAttr, 0)
        try {
            indicatorCount = typedArray.getInt(R.styleable.IndicatorLayout_indicatorCount, 0)
        }finally {
            typedArray.recycle()
        }
        updateIndicators()

    }

    private fun px(dpValue: Float): Int{
        return (dpValue * context.resources.displayMetrics.density).toInt()
    }

    private fun updateIndicators() {
        removeAllViews()
        for(i in 0 until indicatorCount){
            val indicator = View(context)
            val layoutParams = LayoutParams(px(10f), px(10f))
            layoutParams.setMargins(px(3f),px(3f),px(3f),px(3f))
            indicator.layoutParams = layoutParams
            indicator.setBackgroundResource(R.drawable.indicator_unselected)
            addView(indicator)
        }
    }
    fun setIndicatorCount(count: Int) {
        indicatorCount = count
        updateIndicators()
    }

    fun selectCurrentPosition(position: Int) {
        if (position in 0..indicatorCount) {
            selectedPosition = position
            for (index in 0 until indicatorCount) {
                val indicator = getChildAt(index)
                if (index == selectedPosition) {
                    indicator.setBackgroundResource(R.drawable.indicator_selected)
                } else {
                    indicator.setBackgroundResource(R.drawable.indicator_unselected)
                }
            }
        }
    }
}