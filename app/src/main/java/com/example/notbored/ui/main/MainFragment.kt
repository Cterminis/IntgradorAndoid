package com.example.notbored.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.MainFragmentBinding

class MainFragment : Fragment(R.layout.main_fragment) {


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
            val bundle=Bundle()

            button.isEnabled= false
            editTextNumber.doAfterTextChanged {
                button.isEnabled =
                    editTextNumber.text.isNotEmpty() &&  editTextNumber.text.toString().toInt()>=1
            }

            button.setOnClickListener {
                bundle.putString(getString(R.string.key_value),editTextNumber.text.toString())
                findNavController().navigate(R.id.action_mainFragment_to_listOfActivities,bundle)
            }
            textView3.setOnClickListener {
                findNavController().navigate(R.id.action_mainFragment_to_scrollingFragment)
            }


        }
    }

}