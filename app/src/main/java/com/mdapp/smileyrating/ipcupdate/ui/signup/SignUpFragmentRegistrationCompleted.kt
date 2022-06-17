package com.mdapp.smileyrating.ipcupdate.ui.signup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentWelcome1Binding
import com.mdapp.smileyrating.databinding.FrgamentChoseInterestBinding
import com.mdapp.smileyrating.databinding.FrgamentRegistrationCompletedBinding
import com.mdapp.smileyrating.ipcupdate.ui.avataronboard.AvatarOnBoardActivity

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


        handleEvent()
    }

    private fun handleEvent() {
        binding.cvBottom.setOnClickListener {
            if (binding.cbAgree.isChecked){
                val intent = Intent(context, AvatarOnBoardActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(context, "Please agree my rule", Toast.LENGTH_LONG).show()
            }
        }

    }
}