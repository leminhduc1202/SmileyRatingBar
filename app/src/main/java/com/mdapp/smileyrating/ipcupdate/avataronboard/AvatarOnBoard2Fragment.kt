package com.mdapp.smileyrating.ipcupdate.avataronboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentAvatar1Binding
import com.mdapp.smileyrating.databinding.FragmentAvatar2Binding

class AvatarOnBoard2Fragment: Fragment() {

    private lateinit var binding: FragmentAvatar2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAvatar2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {

    }
}