package com.mdapp.smileyrating.screen

import android.annotation.SuppressLint
import android.os.Bundle
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
        binding.animationView.progress = 1f
        binding.tvRating.text =  getString(R.string.highly_likely)
        binding.sbProgress.progress = 110

        var seekBarProgress = 0
        binding.sbProgress.setOnSeekBarChangeListener(@SuppressLint("AppCompatCustomView")
        object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.animationView.progress = (p1.toFloat() /100)
                seekBarProgress = p1
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                when (seekBarProgress){

                    in 80..109 -> let {
                        p0?.progress = 110
                        binding.tvRating.text = getString(R.string.highly_likely)
                    }
                    in 60..79 -> let {
                        p0?.progress = 80
                        binding.tvRating.text = getString(R.string.likely)
                    }
                    in 40..59 -> let {
                        p0?.progress = 60
                        binding.tvRating.text = getString(R.string.neutral)
                    }
                    in 10..39 -> let {
                        p0?.progress = 40
                        binding.tvRating.text = getString(R.string.highly_unlikely)
                    }
                    in 0..9 ->let{
                        p0?.progress = 10
                        binding.tvRating.text = getString(R.string.never)
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