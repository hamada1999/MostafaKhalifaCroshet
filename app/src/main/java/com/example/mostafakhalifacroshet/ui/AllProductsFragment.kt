package com.example.mostafakhalifacroshet.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.adapters.ProductsRecyclerAdapter
import com.example.mostafakhalifacroshet.data.Product
import com.example.mostafakhalifacroshet.models.ProductType
import com.example.mostafakhalifacroshet.models.RemoteDatabase
import com.example.mostafakhalifacroshet.utils.EXTRA_PRODUCT
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
class AllProductsFragment : Fragment()  {
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
            adapter.setListener(object : ProductsRecyclerAdapter.Listener{
                override fun onClick(position: Int) {
                    val intent = Intent(requireActivity() , ProductDetailsActivity::class.java)
                    intent.putExtra(EXTRA_PRODUCT , it[position])
                    startActivity(intent)
                }
            })
        })


    }

    private fun putProductData(){
        val productList = kotlin.collections.ArrayList<Product>()
        productList.add(Product(ProductType.COTTON , UUID.randomUUID().toString(), "Crochet Flower", "kecjwiochdwowhdcjlhdoucvhoeuvebvjevocuegvugerovuhourehvourehvouerhvourevugerugveruogvougrvouhreovuherouvheoruvh[oeurhvhuvher[v"
        , 250 , "https://firebasestorage.googleapis.com/v0/b/mostafa-khalifa.appspot.com/o/%E2%80%94Pngtree%E2%80%94crochet%20flower_8864742.png?alt=media&token=8f3a4442-33cc-42f3-8fa3-35b25cffd89c"
        , 3f , 12 ))
        productList.add(Product(ProductType.COTTON , UUID.randomUUID().toString(), "Crochet Toy", "kecjwiochdwowhdcjlhdoucvhoeuvebvjevocuegvugerovuhourehvourehvouerhvourevugerugveruogvougrvouhreovuherouvheoruvh[oeurhvhuvher[v"
            , 50 , "https://firebasestorage.googleapis.com/v0/b/mostafa-khalifa.appspot.com/o/pngwing.com%20(2).png?alt=media&token=a5fa6aac-d1a5-41dd-a403-08ba3a7fc4b6"
            , 3.5f , 12 ))
        productList.add(Product(ProductType.COTTON , UUID.randomUUID().toString(), "Crochet Barby", "kecjwiochdwowhdcjlhdoucvhoeuvebvjevocuegvugerovuhourehvourehvouerhvourevugerugveruogvougrvouhreovuherouvheoruvh[oeurhvhuvher[v"
            , 500 , "https://firebasestorage.googleapis.com/v0/b/mostafa-khalifa.appspot.com/o/pngwing.com%20(3).png?alt=media&token=f154e670-1c4b-49ed-827b-a64d3ced348b"
            , 5f , 12 ))

        database.getDatabaseRef("Products").child(ProductType.COTTON.toString())
            .setValue(productList)
    }



}