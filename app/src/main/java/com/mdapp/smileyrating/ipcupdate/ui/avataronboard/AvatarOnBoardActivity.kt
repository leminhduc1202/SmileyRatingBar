package com.mdapp.smileyrating.ipcupdate.ui.avataronboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.ActivityAvatarOnBoardBinding
import com.mdapp.smileyrating.ipcupdate.ui.signup.SignUpFragmentChoseInterest
import com.mdapp.smileyrating.ipcupdate.ui.slideradapter.IntroSilderAdapter

class AvatarOnBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAvatarOnBoardBinding
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAvatarOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViewPager()
        registerListeners()
    }

    private fun setViewPager() {
        val adapter = IntroSilderAdapter(this)
        binding.vpSlider.adapter = adapter

        fragmentList.addAll(
            listOf(
                AvatarOnBoard1Fragment(),
                SignUpFragmentChoseInterest(),
                AvatarOnBoard2Fragment(),
                AvatarOnBoard3Fragment(),
                AvatarOnBoard4Fragment(),
                AvatarOnBoard5Fragment(),
            )
        )
        adapter.setFragmentList(fragmentList)
    }

    private fun registerListeners() {
        binding.vpSlider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){

            override fun onPageSelected(position: Int) {
                when (position){
                    0 -> let {
                        binding.ctBottom.visibility = View.GONE
                    }
                    in 1..2 -> let {
                        binding.ctBottom.visibility = View.VISIBLE
                        val positionCurrent = binding.vpSlider.currentItem
                        binding.tvBack.setOnClickListener {
                            binding.vpSlider.currentItem = positionCurrent - 1
                        }
                        binding.tvNext.setOnClickListener {
                            binding.vpSlider.currentItem = positionCurrent + 1
                        }
                    }
                    in 3..5 -> let {
                        binding.ctBottom.visibility = View.GONE
                    }
                }
            }
        })

    }
}