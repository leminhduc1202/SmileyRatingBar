package com.mdapp.smileyrating.ipcupdate.ui.avataronboard

import android.graphics.Typeface
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.mdapp.smileyrating.R
import com.mdapp.smileyrating.databinding.FragmentAvatar4Binding
import com.mdapp.smileyrating.ipctackclub.RecyclerAdapter
import com.mdapp.smileyrating.ipcupdate.ui.avataronboard.adapter.TagAdapter

class AvatarOnBoard4Fragment: Fragment() {

    private lateinit var binding: FragmentAvatar4Binding
    private var mTagAdapter: TagAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvatar4Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        initView()
        addAdapter()
    }

    private fun initView() {
        val textArray = resources.getStringArray(R.array.text_customise)
        for (textTag in textArray){
            val chip = layoutInflater.inflate(R.layout.layout_chip_choice, binding.chipGroup, false) as Chip
            chip.text = textTag
            chip.typeface = Typeface.create(
                ResourcesCompat.getFont(requireContext(), R.font.ikanosans_light), Typeface.NORMAL
            )
            chip.textSize = 16f
            chip.textAlignment = View.TEXT_ALIGNMENT_CENTER
            chip.chipStartPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18f,resources.displayMetrics)
            chip.chipEndPadding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 18f,resources.displayMetrics)

            binding.apply {
                chipGroup.addView(chip)
            }
        }

    }

    private fun addAdapter(){
        binding.apply {
            rcTagCustomise.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val data = resources.getStringArray(R.array.text_customise)
            mTagAdapter = TagAdapter(data, requireContext())
            rcTagCustomise.adapter = mTagAdapter
        }
//        binding.rcTagCustomise.layoutManager =
//            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        val data = arrayOfNulls<String>(4)
//        for (i in data.indices) {
//            data[i] = "item $i"
//        }
//        mTagAdapter = TagAdapter(data, requireContext())
//        binding.rcTagCustomise.adapter = mTagAdapter
    }
}