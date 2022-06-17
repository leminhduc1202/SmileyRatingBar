package com.mdapp.smileyrating.ipcupdate.ui.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mdapp.smileyrating.databinding.ActivityHomePageBinding

class HomePageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomePageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}