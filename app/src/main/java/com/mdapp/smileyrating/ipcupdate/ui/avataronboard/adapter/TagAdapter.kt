package com.mdapp.smileyrating.ipcupdate.ui.avataronboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.mdapp.smileyrating.R

class TagAdapter(
    private val mData: Array<String?>,
    private val mContext: Context
): RecyclerView.Adapter<TagAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var mText: Chip = itemView.findViewById<Chip>(R.id.chipTag)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_tag_customise, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mText.text = mData[position]
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}