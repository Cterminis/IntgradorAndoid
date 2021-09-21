package com.example.notbored.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.FragmentListOfActivitiesBinding
import com.example.notbored.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        with(binding) {

            button.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_listOfActivities)
            }
            textView3.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_scrollingFragment)
            }

        }
    }

}