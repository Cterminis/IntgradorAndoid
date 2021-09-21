package com.example.notbored.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.databinding.FragmentListOfActivitiesBinding

class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = FragmentListOfActivitiesBinding.bind(itemView)

    fun binData(item: String) {

        with(binding) {
            tvActivityName.text = item


        }
    }
}