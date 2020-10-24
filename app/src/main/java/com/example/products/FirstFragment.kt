package com.example.products

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.products.model.MyViewModel.ProductsViewModel
import com.example.products.model.ProductsAdapter
import com.example.products.model.ProductsEntityItem
import kotlinx.android.synthetic.main.fragment_first.*


open class FirstFragment : Fragment(), ProductsAdapter.Products {

    lateinit var mProductsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        mProductsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mRecycleView = recyclerView
        val mProductsAdapter = ProductsAdapter(this)
        mRecycleView.adapter = mProductsAdapter
        mRecycleView.layoutManager = LinearLayoutManager(context)

        mProductsViewModel.mAllProducts.observe(viewLifecycleOwner, Observer{
            mProductsAdapter.updateListProducts(it)
            Log.d("funciona", it.toString())
        })

    }

    override fun passProdcuts(mProducts: ProductsEntityItem) {
        val mBundle = Bundle()
        mBundle.putInt("id", mProducts.id)
        mBundle.putString("imagen", mProducts.image)
        mBundle.putInt("precio", mProducts.price)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, mBundle)
    }
}