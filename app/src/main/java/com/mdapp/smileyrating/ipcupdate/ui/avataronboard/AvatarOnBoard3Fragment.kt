package com.mdapp.smileyrating.ipcupdate.ui.avataronboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentAvatar1Binding
import com.mdapp.smileyrating.databinding.FragmentAvatar2Binding
import com.mdapp.smileyrating.databinding.FragmentAvatar3Binding

class AvatarOnBoard3Fragment: Fragment() {

    private lateinit var binding: FragmentAvatar3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvatar3Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

    }
}