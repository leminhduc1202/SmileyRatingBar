package com.mdapp.smileyrating

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mdapp.smileyrating.databinding.ActivityMainBinding
import com.mdapp.smileyrating.ipcupdate.ui.SplashScreenIPC
import com.mdapp.smileyrating.screen.NpsFragment


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
//        binding.textRun.startAnimation(AnimationUtils.loadAnimation(this, translate))

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
//                when (progressBar) {
//                    in 0..20 -> p0?.progress = 0
//                    in 21..40 -> p0?.progress = 20
//                    in 41..60 -> p0?.progress = 40
//                    in 61..80 -> p0?.progress = 60
//                    else -> p0?.progress = 100
//                }
//                when (progressBar) {
//                    in 0..20 -> binding.tvRating.text = "Never"
//                    in 21..40 -> binding.tvRating.text = "Highly Unlikely"
//                    in 41..60 -> binding.tvRating.text = "Neutral"
//                    in 61..80 -> binding.tvRating.text = "Likely"
//                    else -> binding.tvRating.text = "Highly Likely"
//                }

                when (progressBar) {
                    in 80..100 -> let {
                        p0?.progress = 100
                        binding.tvRating.text = getString(R.string.highly_likely)
                    }
                    in 60..79 -> let {
                        p0?.progress = 80
                        binding.tvRating.text = getString(R.string.likely)
                    }
                    in 40..59 -> let {
                        p0?.progress = 60
                        binding.tvRating.text = getString(R.string.less_likely)
                    }
                    in 20..39 -> let {
                        p0?.progress = 40
                        binding.tvRating.text = getString(R.string.highly_unlikely)
                    }
                    else -> let {
                        p0?.progress = 0
                        binding.tvRating.text = getString(R.string.never)
                    }

                }

            }
        })


        binding.tvShowDialog.setOnClickListener{
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.ctMiddle, NpsFragment())
            fragment.commit()
            onShowDialog()
        }

        binding.tvShowSmiley.setOnClickListener{
            val fragment = supportFragmentManager.beginTransaction()
            fragment.replace(R.id.ctMiddle, SmileyFragment())
            fragment.commit()
            onShowSmiley()
        }

        binding.tvShowUpdate.setOnClickListener {
            onShowUpdate()
            val intent = Intent(this, SplashScreenIPC::class.java)
            startActivity(intent)
        }


//        showRating()
        showRatingTest()

    }

    private fun showRatingTest() {
        binding.animationViewNPSTest.progress = 0f
        binding.tvRatingNPS.text = getString(R.string.highly_likely)
        binding.sbProgressNPS.max = 100
        binding.sbProgressNPS.progress = 100

        var progressSeekBar = 0
        binding.sbProgressNPS.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    binding.animationViewNPSTest.progress = (1 - p1.toFloat() / 100)
                    Log.e("abc", binding.animationViewNPSTest.frame.toString())
                    Log.e("def", binding.animationViewNPSTest.progress.toString())
                    progressSeekBar = p1

                    when (progressSeekBar) {
                        in 0..30 -> let {
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        in 31..60 -> let {
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        in 61..80 -> let {
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        in 81..100 -> let {
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
//                    TODO("Not yet implemented")
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    when (progressSeekBar) {
                        0 -> let {
                            p0?.progress = 0
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        10 -> let {
                            p0?.progress = 10
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        20 -> let {
                            p0?.progress = 20
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        30 -> let {
                            p0?.progress = 30
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        40 -> let {
                            p0?.progress = 40
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        50 -> let {
                            p0?.progress = 50
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        60 -> let {
                            p0?.progress = 60
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        70 -> let {
                            p0?.progress = 70
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        80 -> let {
                            p0?.progress = 80
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        90 -> let {
                            p0?.progress = 90
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        100 -> let {
                            p0?.progress = 100
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                    }
                }
            }
        )

    }

    private fun showRating() {
        binding.animationViewNPS.progress = 0f
        binding.tvRatingNPS.text = getString(R.string.highly_likely)
        binding.sbProgressNPS.progress = 100
        binding.sbProgressNPS.max = 100

        var sbProgressNPS = 0
        binding.sbProgressNPS.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    binding.animationViewNPS.progress = (p1.toFloat() / 100)
//                    if (p1.toFloat() / 100 > 0.5) {
//                        binding.animationViewNPS.visibility = View.GONE
//                        binding.animationViewNPSFinal.apply {
//                            visibility = View.VISIBLE
//                            this.progress = (1 - p1.toFloat() / 100).toFloat()
//                        }
//                    } else {
//                        binding.animationViewNPSFinal.visibility = View.GONE
//                        binding.animationViewNPS.apply {
//                            visibility = View.VISIBLE
//                            this.progress = (0.5 - p1.toFloat() / 100).toFloat()
//                        }
//                    }
                    sbProgressNPS = p1
                    when (sbProgressNPS) {
                        0 -> let {
                            p0?.progress = 0
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        10 -> let {
                            p0?.progress = 10
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        20 -> let {
                            p0?.progress = 20
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        30 -> let {
                            p0?.progress = 30
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        40 -> let {
                            p0?.progress = 40
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        50 -> let {
                            p0?.progress = 50
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        60 -> let {
                            p0?.progress = 60
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        70 -> let {
                            p0?.progress = 70
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        80 -> let {
                            p0?.progress = 80
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        90 -> let {
                            p0?.progress = 90
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        100 -> let {
                            p0?.progress = 100
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                    }
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
//                    TODO("Not yet implemented")
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    when (sbProgressNPS) {
                        0 -> let {
                            p0?.progress = 0
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        10 -> let {
                            p0?.progress = 10
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        20 -> let {
                            p0?.progress = 20
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        30 -> let {
                            p0?.progress = 30
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        40 -> let {
                            p0?.progress = 40
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        50 -> let {
                            p0?.progress = 50
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        60 -> let {
                            p0?.progress = 60
                            binding.tvRatingNPS.text = getString(R.string.less_likely)
                        }
                        70 -> let {
                            p0?.progress = 70
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        80 -> let {
                            p0?.progress = 80
                            binding.tvRatingNPS.text = getString(R.string.likely)
                        }
                        90 -> let {
                            p0?.progress = 90
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                        100 -> let {
                            p0?.progress = 100
                            binding.tvRatingNPS.text = getString(R.string.highly_unlikely)
                        }
                    }
                }

            }
        )
    }

    private fun onShowDialog() {
        binding.tvShowDialog.setTextColor(ContextCompat.getColor(baseContext, R.color.white))
        binding.tvShowDialog.background =
            ContextCompat.getDrawable(baseContext, R.drawable.background_cobalt_radius_41)
        binding.tvShowSmiley.setTextColor(ContextCompat.getColor(baseContext, R.color.cobalt))
        binding.tvShowSmiley.background = null
        binding.tvShowUpdate.setTextColor(ContextCompat.getColor(baseContext, R.color.cobalt))
        binding.tvShowUpdate.background = null
    }

    private fun onShowSmiley(){
        binding.tvShowSmiley.setTextColor(ContextCompat.getColor(baseContext, R.color.white))
        binding.tvShowSmiley.background =
            ContextCompat.getDrawable(baseContext, R.drawable.background_cobalt_radius_41)
        binding.tvShowDialog.setTextColor(ContextCompat.getColor(baseContext, R.color.cobalt))
        binding.tvShowDialog.background = null
        binding.tvShowUpdate.setTextColor(ContextCompat.getColor(baseContext, R.color.cobalt))
        binding.tvShowUpdate.background = null
    }

    private fun onShowUpdate(){
        binding.tvShowUpdate.setTextColor(ContextCompat.getColor(baseContext, R.color.white))
        binding.tvShowUpdate.background =
            ContextCompat.getDrawable(baseContext, R.drawable.background_cobalt_radius_41)
        binding.tvShowDialog.setTextColor(ContextCompat.getColor(baseContext, R.color.cobalt))
        binding.tvShowDialog.background = null
        binding.tvShowSmiley.setTextColor(ContextCompat.getColor(baseContext, R.color.cobalt))
        binding.tvShowSmiley.background = null
    }
}
