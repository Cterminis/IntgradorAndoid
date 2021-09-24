package com.example.notbored.ui.main.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.R
import com.example.notbored.R.id.action_listOfActivities_to_detail
import com.example.notbored.adapter.MyItemRecyclerViewAdapter
import com.example.notbored.databinding.FragmentListOfActivitiesListBinding
/**
 * A fragment representing a list of Items.
 */
class ListOfActivities : Fragment(R.layout.fragment_list_of_activities_list) {

    private var columnCount = 1
    private var _binding: FragmentListOfActivitiesListBinding? = null
    private val binding get() = _binding!!

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

        _binding = FragmentListOfActivitiesListBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.fragment_list_of_activities_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                val lista = resources.getStringArray(R.array.array_categorias)

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