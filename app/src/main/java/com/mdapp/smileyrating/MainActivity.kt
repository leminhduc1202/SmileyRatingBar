package com.mdapp.smileyrating

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RatingBar
import android.widget.TextView
import com.mdapp.smileyrating.R.anim
import com.mdapp.smileyrating.R.anim.translate
import com.mdapp.smileyrating.smiley.SmileyRatingView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RatingBar>(R.id.rating_bar).setOnRatingBarChangeListener { _, rating, _ ->
            findViewById<SmileyRatingView>(R.id.smiley_view).setSmiley(rating = rating)
        }
//animation text run left to right
        findViewById<TextView>(R.id.textRun).startAnimation(AnimationUtils.loadAnimation(this,translate))

    }
}