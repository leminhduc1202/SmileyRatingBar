package com.mdapp.smileyrating

import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.mdapp.smileyrating.R.anim.translate
import com.mdapp.smileyrating.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
//            binding.smileyView.setSmiley(rating = rating)
//        }
//animation text run left to right
        binding.textRun.startAnimation(AnimationUtils.loadAnimation(this, translate))

//animation SeekBar and lottie
        var progressBar = 0
        binding.sbProgress.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.animationView.progress = (p1.toFloat() / 100)
                Log.d("=====p1", (p1.toFloat() / 100).toString())
                progressBar = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {}

            override fun onStopTrackingTouch(p0: SeekBar?) {
                when (progressBar) {
                    in 0..20 -> p0?.progress = 0
                    in 21..40 -> p0?.progress = 20
                    in 41..60 -> p0?.progress = 40
                    in 61..80 -> p0?.progress = 60
                    else -> p0?.progress = 100
                }
                when (progressBar) {
                    in 0..20 -> binding.tvRating.text = "Never"
                    in 21..40 -> binding.tvRating.text = "Highly Unlikely"
                    in 41..60 -> binding.tvRating.text = "Neutral"
                    in 61..80 -> binding.tvRating.text = "Likely"
                    else -> binding.tvRating.text = "Highly Likely"
                }

            }
        })
//animation SeekBar and lottie

    }
}
