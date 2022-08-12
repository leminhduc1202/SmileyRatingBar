package com.mdapp.smileyrating.ipc3.splashscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.FragmentWelcome1Binding
import com.mdapp.smileyrating.utils.gone
import com.mdapp.smileyrating.utils.setMargins
import com.mdapp.smileyrating.utils.visible

class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcome1Binding

    companion object {
        const val GREETING_SCREEN = "GREETING_SCREEN"
        const val USP_1_SCREEN = "USP_1_SCREEN"
        const val USP_2_SCREEN = "USP_2_SCREEN"
        const val USP_3_SCREEN = "USP_3_SCREEN"
        const val CTA_SCREEN = "CTA_SCREEN"
        const val NAME_SCREEN = "NAME_SCREEN"

        fun newInstance(screenName: String): SplashScreenFragment {
            val bundle = Bundle()
            bundle.putString(NAME_SCREEN, screenName)
            val fragment = SplashScreenFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcome1Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        arguments?.getString(NAME_SCREEN).let {
            when (it) {
                GREETING_SCREEN -> {
                    binding.apply {
                        tvSplashContent.apply {
                            text = getString(R.string.well_come)
                            textSize = 50f
                        }
                        imgSplashContent.apply {
                            setImageResource(R.drawable.ic_hey)
                        }
                        imgSplashUSP1.gone()
                    }
                }
                USP_1_SCREEN -> {
                    binding.apply {
                        tvSplashContent.apply {
                            text = getString(R.string.splash_screen_content_usp1)
                            textSize = 40f
                        }
                        imgSplashUSP1.apply {
                            visible()
                            setImageResource(R.drawable.ic_background_splash_usp1)
                        }
                    }
                }
                USP_2_SCREEN -> {
                    binding.apply {
                        tvSplashContentUsp2.apply {
                            visible()
                            text = getString(R.string.splash_screen_content_usp2)
                        }
                        imgSplashUSP2.apply {
                            visible()
                            setImageResource(R.drawable.ic_background_splash_usp2)
                        }
                    }
                }
                USP_3_SCREEN -> {
                    binding.apply {
                        tvSplashContentUsp3.apply {
                            visible()
                            text = getString(R.string.splash_screen_content_usp3)
                        }
                        imgSplashContent.setImageResource(R.drawable.ic_background_splash_usp3)
                    }
                }
                CTA_SCREEN -> {
                    binding.apply {
                        tvSplashContentUsp2.apply {
                            visible()
                            text = getString(R.string.splash_screen_content_cta)
                        }
                        imgSplashUSP2.apply {
                            visible()
                            setImageResource(R.drawable.ic_background_splash_cta)
                            scaleType = ImageView.ScaleType.FIT_CENTER
                            setMargins(36, 17, 0, 14)
                        }

                    }
                }
                else -> {}
            }
        }

    }

}