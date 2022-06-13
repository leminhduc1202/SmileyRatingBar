package com.mdapp.smileyrating.ipcupdate

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.smileyrating.MainActivity
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.SmileyFragment
import com.mdapp.smileyrating.databinding.ActivitySplashScreenIpcBinding
import com.mdapp.smileyrating.ipcupdate.slider.IntroSilderAdapter
import com.mdapp.smileyrating.screen.NpsFragment

class SplashScreenIPC : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenIpcBinding
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenIpcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = IntroSilderAdapter(this)
        binding.vpSlider.adapter = adapter

        fragmentList.addAll(listOf(SmileyFragment(), NpsFragment()))
        adapter.setFragmentList(fragmentList)

        binding.indicatorLayout.setIndicatorCount(adapter.itemCount)
        binding.indicatorLayout.selectCurrentPosition(0)

        registerListeners()

    }

    private fun registerListeners() {
        binding.vpSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)
                if (position < fragmentList.lastIndex) {
                    binding.tvBack.visibility = View.GONE
                    binding.tvNext.text = getString(R.string.next)
                } else {
                    binding.tvBack.visibility = View.VISIBLE
                    binding.tvBack.setOnClickListener {
                        binding.vpSlider.currentItem = binding.vpSlider.currentItem - 1
                    }
                    binding.tvNext.text = getString(R.string.get_started)
                }
            }
        })

//        binding.tvBack.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
//        }

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