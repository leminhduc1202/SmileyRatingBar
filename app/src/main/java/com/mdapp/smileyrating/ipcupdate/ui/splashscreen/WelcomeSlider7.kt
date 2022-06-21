package com.mdapp.smileyrating.ipcupdate.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.MainActivity
import com.mdapp.smileyrating.databinding.FragmentWelcome1Binding
import com.mdapp.smileyrating.databinding.FragmentWelcome5Binding
import com.mdapp.smileyrating.databinding.FragmentWelcome6Binding
import com.mdapp.smileyrating.databinding.FragmentWelcome7Binding
import com.mdapp.smileyrating.ipcupdate.ui.signup.SignUpActivity

class WelcomeSlider7: Fragment() {

    private lateinit var binding: FragmentWelcome7Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcome7Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleEvent()


    }

    private fun handleEvent() {

    }

}