package com.mdapp.smileyrating.ipcupdate.signup

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.ActivitySignUpBinding
import com.mdapp.smileyrating.ipcupdate.SplashScreenIPC
import com.mdapp.smileyrating.ipcupdate.slider.IntroSilderAdapter

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private val fragmentList = ArrayList<Fragment>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
        registerListeners()

    }



    private fun setViewPager() {
        val adapter = IntroSilderAdapter(this)
        binding.vpSlider.adapter = adapter

        fragmentList.addAll(listOf(SignUpFragment(),SignUpFragmentChoseInterest(), SignUpFragmentRegistrationCompleted()))
        adapter.setFragmentList(fragmentList)

    }
    private fun registerListeners() {
        binding.vpSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                when (position){
                    0 -> let {
                        binding.tvNext.setTextColor(ContextCompat.getColor(this@SignUpActivity, R.color.gray_two_b_main_color))
                        binding.tvWhyAsk.visibility = View.VISIBLE
                        binding.ctBottom.visibility = View.VISIBLE

                    }
                    1 -> let {
                        binding.tvNext.setTextColor(ContextCompat.getColor(this@SignUpActivity, R.color.hollywood_cerise))
                        binding.tvWhyAsk.visibility = View.GONE
                        binding.ctBottom.visibility = View.VISIBLE

                    }
                    2 -> let {
                        binding.ctBottom.visibility = View.GONE

                    }
                }
            }
        })

        binding.tvBack.setOnClickListener {
            val position = binding.vpSlider.currentItem
            if (position == 0){
                startActivity(Intent(this, SplashScreenIPC::class.java))
            }else{
                binding.vpSlider.currentItem = position - 1
            }


        }

        binding.tvNext.setOnClickListener {
            val position = binding.vpSlider.currentItem
            if (position < fragmentList.lastIndex){
                binding.vpSlider.currentItem = position + 1
            }else{
                //
            }
        }
    }

}