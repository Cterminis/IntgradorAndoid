package com.example.notbored.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notbored.R

private const val ARG_PARAM1 = "personas" // pasa el nombre
private const val ARG_PARAM2 = "nombreActividad"

class Detail : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewModel: MainViewModel


    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        Toast.makeText(requireContext(), "holi $param1", Toast.LENGTH_SHORT).show()
        Log.i("Juanita", "onCreate: $param1")
        param1?.let { viewModel.getdetail(it, "recreational") }
        binding = FragmentDetailBinding.inflate(layoutInflater)
        viewModel.detailActivity.observe(viewLifecycleOwner, {

            binding.tvDetalleTitulo.text = it.activity


        })

    }
*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        return view


    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        val txt = view?.findViewById<TextView>(R.id.tv_detalle_titulo)
        val txt2 = view?.findViewById<TextView>(R.id.tv_activity_name)
        val txt3 = view?.findViewById<TextView>(R.id.tv_gente)
        val txt4 = view?.findViewById<TextView>(R.id.tv_categoria)

        with(viewModel) {

           // getdetailExample(param1!!)

            getdetail("recreational","1")

            detailActivity.observe(viewLifecycleOwner, {

                   txt?.text=it.activity // titulo
                   txt4?.text=it.price //categori
                   txt3?.text=it.participants //cantidad
                   txt2?.text=it.price


            })
        }


    }
}