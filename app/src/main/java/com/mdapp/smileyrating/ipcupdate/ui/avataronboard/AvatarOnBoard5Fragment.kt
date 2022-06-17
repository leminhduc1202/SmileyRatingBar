package com.mdapp.smileyrating.ipcupdate.ui.avataronboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentAvatar1Binding
import com.mdapp.smileyrating.databinding.FragmentAvatar2Binding
import com.mdapp.smileyrating.databinding.FragmentAvatar4Binding
import com.mdapp.smileyrating.databinding.FragmentAvatar5Binding

class AvatarOnBoard5Fragment: Fragment() {

    private lateinit var binding: FragmentAvatar5Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvatar5Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

    }
}