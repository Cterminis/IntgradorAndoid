package com.example.notbored.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.R


class MyItemRecyclerViewAdapter(val lista: ArrayList<String>, val listener: View.OnClickListener) :
    RecyclerView.Adapter<CategoryViewHolder>(), View.OnClickListener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_list_of_activities, parent, false)
        view.setOnClickListener(this)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.binData(lista[position])
    }

    override fun getItemCount(): Int = lista.size

    //  interface onItemselected {
    //      fun onItemClick(data: String)
    // }

    //fun setOnItemClickListener(listener: onItemselected) {
    //    this.listener = listener
    // }

    override fun onClick(view: View?) {
        view.let { listener.onClick(it) }
    }
}
