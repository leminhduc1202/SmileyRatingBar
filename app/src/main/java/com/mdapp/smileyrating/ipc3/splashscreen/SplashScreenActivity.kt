package com.mdapp.smileyrating.ipc3.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.ActivitySplashScreenBinding
import com.mdapp.smileyrating.ipc3.signup.SignUpScreenActivity
import com.mdapp.smileyrating.ipc3.splashscreen.SplashScreenFragment.Companion.CTA_SCREEN
import com.mdapp.smileyrating.ipc3.splashscreen.SplashScreenFragment.Companion.GREETING_SCREEN
import com.mdapp.smileyrating.ipc3.splashscreen.SplashScreenFragment.Companion.USP_1_SCREEN
import com.mdapp.smileyrating.ipc3.splashscreen.SplashScreenFragment.Companion.USP_2_SCREEN
import com.mdapp.smileyrating.ipc3.splashscreen.SplashScreenFragment.Companion.USP_3_SCREEN
import com.mdapp.smileyrating.ipcupdate.ui.signup.SignUpActivity
import com.mdapp.smileyrating.ipcupdate.ui.slideradapter.IntroSliderAdapter
import com.mdapp.smileyrating.utils.gone
import com.mdapp.smileyrating.utils.visible

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            binding.imgLogo.gone()
            initView()
        }, 3000)


    }

    private fun initView() {
        binding.apply {
            vpSplashScreen.visible()
            tvSkip.visible()
            tvNext.visible()
            ilSplashScreen.visible()
        }
        setViewPager()

    }


    private fun setViewPager() {
        val adapter = IntroSliderAdapter(this)
        binding.vpSplashScreen.adapter = adapter

        fragmentList.addAll(
            listOf(
                SplashScreenFragment.newInstance(GREETING_SCREEN),
                SplashScreenFragment.newInstance(USP_1_SCREEN),
                SplashScreenFragment.newInstance(USP_2_SCREEN),
                SplashScreenFragment.newInstance(USP_3_SCREEN),
                SplashScreenFragment.newInstance(CTA_SCREEN),
            )
        )
        adapter.setFragmentList(fragmentList)
        binding.apply {
            ilSplashScreen.apply {
                setIndicatorCount(adapter.itemCount)
                selectCurrentPosition(0)

            }
            vpSplashScreen.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    binding.ilSplashScreen.selectCurrentPosition(position)
                    if (position == fragmentList.lastIndex ) {
                        isLastFragment(true)
                    }else{
                        isLastFragment(false)
                    }
                }
            })
        }
    }

    private fun isLastFragment(isLastIndex : Boolean){
        binding.apply {
            if (isLastIndex){
                tvSkip.gone()
                ilSplashScreen.gone()
                tvMayBeLater.apply {
                    visible()
                    setOnClickListener {
                        // skip to login screen
                    }
                }
                tvSignUp.apply {
                    visible()
                    setOnClickListener {
                        // go to Sign up
                        startActivity(Intent(context,SignUpScreenActivity::class.java))
                    }
                }
                tvNext.apply {
                    text = getString(R.string.splash_screen_button_content_cta)
                    setTextColor(ContextCompat.getColor(context, R.color.blue_main_color))
                    setBackgroundResource(R.drawable.background_rounder_card_view)
                    setOnClickListener {
                        // go to Login existing account
                    }
                }
            }else{
                tvSkip.apply {
                    visible()
                    setOnClickListener {
                        // skip to login screen
                        startActivity(Intent(context,SignUpScreenActivity::class.java))
                    }
                }
                ilSplashScreen.visible()
                tvMayBeLater.gone()
                tvNext.apply {
                    visible()
                    text = getString(R.string.next)
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    setBackgroundResource(R.drawable.background_card_view)
                    setOnClickListener {
                        vpSplashScreen.currentItem = vpSplashScreen.currentItem + 1
                    }
                }
                tvSignUp.gone()
            }
        }
    }

}