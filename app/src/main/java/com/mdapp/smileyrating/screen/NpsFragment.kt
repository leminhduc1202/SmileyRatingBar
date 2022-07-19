package com.mdapp.smileyrating.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.FrgamentDialogBinding

class NpsFragment : Fragment() {

    private lateinit var binding: FrgamentDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgamentDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleEvent()
    }

    private fun handleEvent() {
        binding.animationView.progress = 0f
        binding.tvRating.text =  getString(R.string.highly_likely)
        binding.sbProgress.max = 100
        binding.sbProgress.progress = 100

        var seekBarProgress = 0
        binding.sbProgress.setOnSeekBarChangeListener(@SuppressLint("AppCompatCustomView")
        object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.animationView.progress = (p1.toFloat() /100)
                Log.d("=====p1", (p1.toFloat() / 100).toString())
                Log.d("aaa", binding.animationView.frame.toString())
                seekBarProgress = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                when (seekBarProgress){
                    in 76..100 -> let {
                        p0?.progress = 100
                        binding.tvRating.text = getString(R.string.highly_likely)


                    }
                    in 51..75 -> let {
                        p0?.progress = 75
                        binding.tvRating.text = getString(R.string.likely)


                    }
                    in 26..50 -> let {
                        p0?.progress = 50
                        binding.tvRating.text = getString(R.string.likely)


                    }
                    in 1..25 -> let {
                        p0?.progress = 25
                        binding.tvRating.text = getString(R.string.less_likely)


                    }
                    0 -> {
                        p0?.progress = 0
                        binding.tvRating.text = getString(R.string.highly_unlikely)


                    }

                }
            }
        })

        binding.btnSkip.setOnClickListener {
            binding.ctLayout.visibility = View.GONE
        }

        binding.imgBtnClose.setOnClickListener {
            binding.ctLayout.visibility = View.GONE
        }

        binding.btnSubmit.setOnClickListener {
            binding.cvRecommend.visibility = View.GONE
            binding.cvFeedBack.visibility = View.VISIBLE
        }

        binding.btnBack.setOnClickListener {
            binding.ctLayout.visibility = View.GONE
        }

    }

}