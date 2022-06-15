package com.mdapp.smileyrating.ipcupdate.signup

import android.content.res.ColorStateList
import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
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
            val chip = Chip(context)
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

//            chip.backgroundDrawable = ChipDrawable.createFromAttributes(requireContext(),null, 0, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice)
//            chip.chipBackgroundColor =
//                ColorStateList.valueOf(getColor(requireContext(), R.color.white))

            binding.chipGroup.addView(chip)

//            binding.chipGroup.checkedChipIds.forEach { _ ->
//                val userText: String = chip.text.toString()
//                Toast.makeText(requireContext(), userText, Toast.LENGTH_LONG).show()
//                chip.chipBackgroundColor =
//                    ColorStateList.valueOf(getColor(requireContext(), R.color.text_color_welcome))
//            }

            chip.setOnClickListener {
                val userText: String = chip.text.toString()
                Toast.makeText(requireContext(), userText, Toast.LENGTH_LONG).show()
                chip.chipBackgroundColor =
                    ColorStateList.valueOf(getColor(requireContext(), R.color.text_color_welcome))
            }
        }
    }


}