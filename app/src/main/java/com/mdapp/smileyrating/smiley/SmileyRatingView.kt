package com.mdapp.smileyrating.smiley

import android.content.Context
import android.graphics.Canvas
import android.os.Build
import android.os.Build.VERSION_CODES
import android.util.AttributeSet
import android.view.View

class SmileyRatingView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleInt: Int = 0
) : View(context, attributeSet, defStyleInt) {

    private val drawer: SmileyFaceDrawer

    init {
        if (Build.VERSION.SDK_INT < VERSION_CODES.JELLY_BEAN_MR2) {
            setLayerType(LAYER_TYPE_SOFTWARE, null)
        }
        drawer = SmileyFaceDrawer(context, attributeSet)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        drawer.onMeasure(measuredWidth, measuredHeight)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawer.drawFace(canvas)
    }

    fun setSmiley(rating: Float) {
        drawer.updateRating(rating) { invalidate() }
    }
}