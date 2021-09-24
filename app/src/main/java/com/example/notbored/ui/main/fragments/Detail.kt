package com.example.notbored.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notbored.R
import com.example.notbored.databinding.FragmentDetailBinding
import com.example.notbored.ui.main.MainViewModel
import kotlin.random.Random


class Detail : Fragment(R.layout.fragment_detail) {
    // TODO: Rename and change types of parameters
    private lateinit var quantity: String
    private lateinit var category: String

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            quantity = it.getString(getString(R.string.key_value)).toString()
            category = it.getString(getString(R.string.key_value_category)).toString()
        }?: arguments.run {
            //getRandom
            category= resources.getStringArray(R.array.array_categorias).random()
            quantity="1"
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        tryAnother()
        with(binding) {

            button2.setOnClickListener {

                if (tvErrorBody.isVisible){
                    findNavController().navigate(R.id.action_detail_to_mainFragment)
                }else{
                    tryAnother()

                }
            }

        }

        return binding.root
    }

    fun tryAnother() {

        with(binding) {

            with(viewModel) {

                getdetail(category, quantity)

                isLoadingProgressBar.observe(viewLifecycleOwner) {
                    hide(it)
                }

                errMessage.observe(viewLifecycleOwner) { res ->
                    tvErrorBody.isVisible = res
                    tvErrorFace.isVisible = res
                    tvDetalleTitulo.isVisible = !res
                    linearLayout2.isVisible = !res
                    errShowMessage.observe(viewLifecycleOwner) {
                        Toast.makeText(context, "$it.error", Toast.LENGTH_SHORT).show()
                    }
                }

                detailActivity.observe(viewLifecycleOwner) {
                    //validar
                    tvDetalleTitulo.text = it.activity // titulo
                    tvPrecio.text = showPrice(it.price.toFloat())
                    tvGente.text = it.participants //cantidad
                    tvCategoria.text = category //categori

                }
            }

        }
    }

    private fun hide(it: Boolean) {
        with(binding){
            linearLayout.isVisible = !it
            linearLayout2.isVisible = !it
            textView6.isVisible = !it
            textView8.isVisible = !it
            tvCategoria.isVisible=!it
            tvPrecio.isVisible=!it
            tvGente.isVisible=!it
            progressBar.isVisible = it
            tvDetalleTitulo.isVisible = !it
        }

    }

    fun showPrice(toFloat: Float): String {

        Toast.makeText(context, "$toFloat", Toast.LENGTH_SHORT).show()
        return when {
            0f == toFloat -> "FREE"
            (toFloat > 0f && toFloat <= 0.3f) -> "LOW"
            toFloat > 0.3f && toFloat <= 0.6f -> "MEDIUM"
            else -> "HIGH"
        }
    }

}