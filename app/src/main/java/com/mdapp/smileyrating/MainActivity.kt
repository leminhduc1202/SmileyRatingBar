package com.mdapp.smileyrating

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
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

        showRatingTest()

    }

    //animation SeekBar and lottie
    private fun showRatingTest() {
        binding.apply {
            sbProgressNPS.progress = 100
            tvRatingNPS.text = getString(R.string.highly_likely)
            animationViewNPSTest.setMinAndMaxFrame(225, 288)
            animationViewNPSTest.playAnimation()

            sbProgressNPS.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                var animProgress = -1
                override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                    val progress = (p1.toFloat() - 1) / 100
                    Log.d("====", progress.toString())
                    animProgress = when (p1) {
                        in 0..30 -> {
                            if (animProgress != 0) {
                                binding.apply {
                                    animationViewNPSTest.setMinAndMaxFrame(0, 66)
                                    animationViewNPSTest.playAnimation()
                                    tvRatingNPS.text = getString(R.string.highly_unlikely)
                                }
                            }
                            0
                        }
                        in 31..60 -> {
                            if (animProgress != 1) {
                                binding.apply {
                                    animationViewNPSTest.setMinAndMaxFrame(77, 133)
                                    animationViewNPSTest.playAnimation()
                                    tvRatingNPS.text = getString(R.string.less_likely)
                                }
                            }
                            1
                        }
                        in 61..80 -> {
                            if (animProgress != 2) {
                                binding.apply {
                                    animationViewNPSTest.setMinAndMaxFrame(150, 215)
                                    animationViewNPSTest.playAnimation()
                                    tvRatingNPS.text = getString(R.string.likely)
                                }
                            }
                            2
                        }
                        else -> {
                            if (animProgress != 3) {
                                binding.apply {
                                    animationViewNPSTest.setMinAndMaxFrame(225, 288)
                                    animationViewNPSTest.playAnimation()
                                    tvRatingNPS.text = getString(R.string.highly_likely)
                                }
                            }
                            3
                        }
                    }
                    Log.d("animProgress", animProgress.toString())
                    Log.d("frame", binding.animationViewNPSTest.frame.toString())
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                    p0?.run {

                    }
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                    p0?.progress = when(p0?.progress){
                        in 0..4 -> 0
                        in 5..14 -> 10
                        in 15..24 -> 20
                        in 25..34 -> 30
                        in 35..44 -> 40
                        in 45..54 -> 50
                        in 55..64 -> 60
                        in 65..74 -> 70
                        in 75..84 -> 80
                        in 85..94 -> 90
                        else -> 100
                    }
                    Log.e("p0", p0?.progress.toString())
                }
            })
            btnSubmit.setOnClickListener {
                Toast.makeText(this@MainActivity,((binding.sbProgressNPS.progress)/10).toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
    //animation SeekBar and lottie


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
