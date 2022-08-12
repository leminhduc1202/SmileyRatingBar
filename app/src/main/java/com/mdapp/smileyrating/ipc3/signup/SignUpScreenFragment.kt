package com.mdapp.smileyrating.ipc3.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mdapp.smileyrating.databinding.FragmentWelcome2Binding

class SignUpScreenFragment : Fragment() {

    private lateinit var binding: FragmentWelcome2Binding

    companion object {


        fun newInstance(): SignUpScreenFragment {
            val bundle = Bundle()

            val fragment = SignUpScreenFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcome2Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    private fun initView() {
        //
    }

}