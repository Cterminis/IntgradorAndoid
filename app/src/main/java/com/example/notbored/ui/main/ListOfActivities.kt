package com.example.notbored.ui.main

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.R
import com.example.notbored.R.id.action_listOfActivities_to_detail
import com.example.notbored.adapter.MyItemRecyclerViewAdapter


/**
 * A fragment representing a list of Items.
 */
class ListOfActivities : Fragment() {

    private var columnCount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {

            it.putString(getString(R.string.key_value),
                it.getString(getString(R.string.key_value)).toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_of_activities_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                //  val lista= resources.getStringArray(R.array.array_categorias)
                val lista = arrayListOf("education",
                    "recreational",
                    "social",
                    "diy",
                    "charity",
                    "cooking",
                    "relaxation",
                    "music",
                    "busywork")
                adapter = MyItemRecyclerViewAdapter(lista) { view ->
                    val category = lista[getChildAdapterPosition(view)]

                    arguments.let {
                        it?.putString(getString(R.string.key_value_category), category)
                    }
                    findNavController().navigate(action_listOfActivities_to_detail, arguments)
                }

            }
        }
        return view
    }


}