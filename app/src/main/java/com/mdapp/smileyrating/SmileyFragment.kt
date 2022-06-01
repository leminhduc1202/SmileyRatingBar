package com.mdapp.smileyrating

import android.os.Bundle
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentSmileyBinding

class SmileyFragment : Fragment() {

    private lateinit var binding: FragmentSmileyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSmileyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleEvent()
    }

    private fun handleEvent() {

        binding.imgBtnClose.setOnClickListener {
            binding.cvSmiley.visibility = View.GONE
        }


    }

}
