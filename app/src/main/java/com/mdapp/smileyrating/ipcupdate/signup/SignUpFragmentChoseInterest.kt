package com.mdapp.smileyrating.ipcupdate.signup

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.FrgamentChoseInterestBinding

class SignUpFragmentChoseInterest: Fragment() {

    private lateinit var binding: FrgamentChoseInterestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgamentChoseInterestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }


    private fun initView() {
       val textArray : Array<String> = resources.getStringArray(R.array.text_tag)
        for (textTag in textArray ) {

            val chip = layoutInflater.inflate(R.layout.layout_chip_choice, binding.chipGroup, false) as Chip
            chip.text = textTag
            chip.typeface = Typeface.create(
                ResourcesCompat.getFont(requireContext(), R.font.ikanosans_light),
                Typeface.NORMAL
            )
            chip.textSize = 16f
            chip.textAlignment = View.TEXT_ALIGNMENT_CENTER
//            set start, end padding
            chip.chipStartPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18f,resources.displayMetrics)
            chip.chipEndPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18f,resources.displayMetrics)



            binding.chipGroup.addView(chip)

        }
    }


}