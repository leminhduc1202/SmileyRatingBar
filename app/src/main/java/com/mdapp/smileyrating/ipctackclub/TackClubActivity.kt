package com.mdapp.smileyrating.ipctackclub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mdapp.smileyrating.databinding.ActivityTackClubBinding

class TackClubActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTackClubBinding
    private var mAdapter: RecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTackClubBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val dataSet = arrayOfNulls<String>(50)
        for (i in dataSet.indices){
            dataSet[i] = "item $i"
        }
        mAdapter = RecyclerAdapter(dataSet, this)
        binding.recyclerView.adapter = mAdapter
    }
}