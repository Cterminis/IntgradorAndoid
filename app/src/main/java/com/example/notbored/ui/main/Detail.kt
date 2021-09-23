package com.example.notbored.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notbored.R
import com.example.notbored.databinding.FragmentDetailBinding


class Detail : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var quantity: String
    private lateinit var category: String

    private lateinit var viewModel: MainViewModel
    //private lateinit var binding: FragmentDetailBinding

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
            quantity = it.getString(getString(R.string.key_value)).toString()
            category = it.getString(getString(R.string.key_value_category)).toString()
        }

        val txt = view?.findViewById<TextView>(R.id.tv_detalle_titulo)
        val txt2 = view?.findViewById<TextView>(R.id.tv_precio)
        val txt3 = view?.findViewById<TextView>(R.id.tv_gente)
        val txt4 = view?.findViewById<TextView>(R.id.tv_categoria)

        val btn = view?.findViewById<Button>(R.id.button2)

        val pb = view?.findViewById<ProgressBar>(R.id.progressBar)


        val ly1 = view?.findViewById<LinearLayout>(R.id.linearLayout)
        val ly2 = view?.findViewById<LinearLayout>(R.id.linearLayout2)

        val txtError = view?.findViewById<TextView>(R.id.tv_error_body)
        val txtErrorAdorno = view?.findViewById<TextView>(R.id.tv_error_face)

        with(viewModel) {

            // getdetailExample(param1!!)

            getdetail(category, quantity)
            isLoadingProgressBar.observe(viewLifecycleOwner){
            pb?.isVisible=it
                txt?.isVisible=!it
                ly1?.isVisible=!it
                ly2?.isVisible=!it

            }


           /*

            errMessage.observe(viewLifecycleOwner){ res ->
                txtError?.isVisible=res
                txtErrorAdorno?.isVisible=res
               errShowMessage.observe(viewLifecycleOwner){
                   Toast.makeText(context, "$it.error", Toast.LENGTH_SHORT).show()
                }
            }

            */

            detailActivity.observe(viewLifecycleOwner, {
                //validar
                txt?.text = it.activity // titulo
                txt2?.text = showPrice(it.price.toFloat())
                txt3?.text = it.participants //cantidad
                txt4?.text = category //categori

            })
        }

        btn?.setOnClickListener {
            tryAnother()
        }

    }

    fun tryAnother() {
        val txt = view?.findViewById<TextView>(R.id.tv_detalle_titulo)
        val txt2 = view?.findViewById<TextView>(R.id.tv_precio)
        val txt3 = view?.findViewById<TextView>(R.id.tv_gente)
        val txt4 = view?.findViewById<TextView>(R.id.tv_categoria)


        with(viewModel) {

            getdetailExample()

            detailActivity.observe(viewLifecycleOwner, {

                txt?.text = it.activity // titulo
                txt2?.text = showPrice(it.price.toFloat())
                txt3?.text = it.participants //cantidad
                txt4?.text = category//categori

            })

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