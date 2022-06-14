package com.mdapp.smileyrating.ipcupdate.splashscreen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.MainActivity
import com.mdapp.smileyrating.databinding.FragmentWelcome1Binding
import com.mdapp.smileyrating.databinding.FragmentWelcome5Binding
import com.mdapp.smileyrating.ipcupdate.signup.SignUpActivity

class WelcomeSlider5: Fragment() {

    private lateinit var binding: FragmentWelcome5Binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcome5Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleEvent()


    }

    private fun handleEvent() {
        binding.tvMayBeLater.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(context, SignUpActivity::class.java))
        }
    }

}