package com.mdapp.smileyrating.ipcupdate.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.smileyrating.MainActivity
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.ActivitySplashScreenIpcBinding
import com.mdapp.smileyrating.ipcupdate.ui.slideradapter.IntroSilderAdapter
import com.mdapp.smileyrating.ipcupdate.ui.splashscreen.*

class SplashScreenIPC : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenIpcBinding
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenIpcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        }else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        setViewPager()
        registerListeners()

    }

    private fun setViewPager() {
        val adapter = IntroSilderAdapter(this)
        binding.vpSlider.adapter = adapter

        fragmentList.addAll(
            listOf(
                WelcomeSlider1(), WelcomeSlider2(),
                WelcomeSlider3(), WelcomeSlider4(),
                WelcomeSlider5(), WelcomeSlider6(),
                WelcomeSlider7(), WelcomeSlider8()
            )
        )
        adapter.setFragmentList(fragmentList)
        binding.indicatorLayout.setIndicatorCount(adapter.itemCount - 3)
        binding.indicatorLayout.selectCurrentPosition(0)
    }

    private fun registerListeners() {
        binding.vpSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)
                if (position == 0){
                    binding.tvBack.visibility = View.GONE
                    binding.tvNext.text = getString(R.string.next)
                    binding.tvNext.visibility = View.VISIBLE
                    binding.tvWhyAsk.visibility = View.GONE
                    binding.indicatorLayout.visibility = View.VISIBLE

                }
                if (position in 1 ..3) {
                    binding.tvBack.visibility = View.VISIBLE
                    binding.tvNext.text = getString(R.string.next)
                    binding.tvNext.visibility = View.VISIBLE
                    binding.tvWhyAsk.visibility = View.GONE
                    binding.indicatorLayout.visibility = View.VISIBLE

                }
                if (position == 4){
                    binding.tvBack.visibility = View.VISIBLE
                    binding.tvNext.visibility = View.GONE
                    binding.tvWhyAsk.visibility = View.GONE
                    binding.indicatorLayout.visibility = View.VISIBLE

                }
                if (position == 5){
                    binding.tvWhyAsk.visibility =View.VISIBLE
                    binding.tvNext.visibility = View.VISIBLE
                    binding.indicatorLayout.visibility = View.GONE
                    binding.tvBack.visibility = View.GONE

                }
                if (position == fragmentList.lastIndex - 1){
                    binding.tvBack.visibility = View.VISIBLE
                    binding.tvWhyAsk.visibility = View.VISIBLE
                    binding.indicatorLayout.visibility = View.GONE
                }
                if (position == fragmentList.lastIndex ){
                    binding.tvBack.visibility = View.GONE
                    binding.tvWhyAsk.visibility = View.GONE
                    binding.indicatorLayout.visibility = View.GONE
                    binding.tvNext.visibility = View.GONE
                }

//                if (position < fragmentList.lastIndex) {
//                    binding.tvBack.visibility = View.VISIBLE
//                    binding.tvNext.text = getString(R.string.next)
//                } else {
//                    binding.tvBack.visibility = View.GONE
////                    binding.tvBack.setOnClickListener {
////                        binding.vpSlider.currentItem = binding.vpSlider.currentItem - 1
////                    }
//                    binding.tvNext.text = getString(R.string.get_started)
//                }
            }
        })

        binding.tvBack.setOnClickListener {
            binding.vpSlider.currentItem = binding.vpSlider.currentItem - 1
        }

        binding.tvNext.setOnClickListener {
            val position = binding.vpSlider.currentItem
            if (position < fragmentList.lastIndex) {
                binding.vpSlider.currentItem = position + 1
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

}

