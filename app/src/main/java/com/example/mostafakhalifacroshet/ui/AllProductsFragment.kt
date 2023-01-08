package com.example.mostafakhalifacroshet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.adapters.ProductsRecyclerAdapter
import com.example.mostafakhalifacroshet.data.Product
import com.example.mostafakhalifacroshet.models.RemoteDatabase
import com.example.mostafakhalifacroshet.viewModels.HomeViewModel
import java.util.*
import kotlin.collections.ArrayList

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AllProductsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AllProductsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var database = RemoteDatabase()
    private lateinit var allRecycler : RecyclerView
    private lateinit var viewModel : HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_all_products, container, false)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        allRecycler = view.findViewById(R.id.all_recycler)
        initRecycler()

        return view
    }


     fun initRecycler(){
        var layoutManager = GridLayoutManager(requireContext(), 2)
        allRecycler.layoutManager = layoutManager

        // set recycler Adapter
        viewModel.productData.observe(viewLifecycleOwner , androidx.lifecycle.Observer {
            var adapter = ProductsRecyclerAdapter(it, requireContext())
            allRecycler.adapter = adapter
        })
    }


}