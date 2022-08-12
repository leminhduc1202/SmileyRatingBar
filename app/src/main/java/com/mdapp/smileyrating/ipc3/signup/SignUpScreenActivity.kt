package com.mdapp.smileyrating.ipc3.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.ActivitySignUpScreenBinding
import com.mdapp.smileyrating.ipcupdate.ui.slideradapter.IntroSliderAdapter
import com.mdapp.smileyrating.utils.gone

class SignUpScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpScreenBinding
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setViewPager()

    }

    private fun initView() {
        binding.tvBack.gone()
    }

    private fun setViewPager(){
        val adapter = IntroSliderAdapter(this)
        binding.vpSignUpScreen.adapter = adapter

        fragmentList.addAll(listOf(
            SignUpScreenFragment.newInstance(),
        ))
        adapter.setFragmentList(fragmentList)

        binding.apply {
            ilSignUpScreen.apply {
                setIndicatorCount(adapter.itemCount)
                selectCurrentPosition(0)
            }
            tvBack.setOnClickListener {
                vpSignUpScreen.currentItem = vpSignUpScreen.currentItem - 1
            }

            tvNext.setOnClickListener {
                vpSignUpScreen.currentItem = vpSignUpScreen.currentItem + 1
            }

            vpSignUpScreen.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    ilSignUpScreen.selectCurrentPosition(position)

                }
            })
        }

    }
}