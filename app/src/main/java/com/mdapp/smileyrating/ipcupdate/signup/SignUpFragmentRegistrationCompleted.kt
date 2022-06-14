package com.mdapp.smileyrating.ipcupdate.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentWelcome1Binding
import com.mdapp.smileyrating.databinding.FrgamentChoseInterestBinding
import com.mdapp.smileyrating.databinding.FrgamentRegistrationCompletedBinding

class SignUpFragmentRegistrationCompleted: Fragment() {

    private lateinit var binding: FrgamentRegistrationCompletedBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FrgamentRegistrationCompletedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}