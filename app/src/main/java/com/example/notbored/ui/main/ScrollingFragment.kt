package com.example.notbored.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.FragmentScrollingBinding

class ScrollingFragment : Fragment() {
private  lateinit var binding: FragmentScrollingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding= FragmentScrollingBinding.inflate(inflater,container,false)


        return binding.root



    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.ibClose.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}