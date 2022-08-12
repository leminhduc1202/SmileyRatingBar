package com.mdapp.smileyrating.ipcupdate.ui.homepage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.ActivityHomePageBinding
import com.mdapp.smileyrating.ipcupdate.ui.slideradapter.IntroSliderAdapter

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding
    private val fragmentList = ArrayList<Fragment>()
    private val isLogin: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
    }

    private fun setViewPager() {
        val adapter = IntroSliderAdapter(this)
        binding.vpPager.adapter = adapter

        fragmentList.addAll(listOf(
            HomePageFragment()
        ))
        adapter.setFragmentList(fragmentList)
        if (isLogin == true){
            binding.vpPager.currentItem = 1
        }else{
            binding.vpPager.currentItem = 0
        }
    }
}