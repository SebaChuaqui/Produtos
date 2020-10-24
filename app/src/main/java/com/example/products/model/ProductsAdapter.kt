package com.example.products.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.products.FirstFragment
import com.example.products.R
import kotlinx.android.synthetic.main.products.view.*

class ProductsAdapter(var mPassProducts: FirstFragment): RecyclerView.Adapter<ProductsAdapter.TaskWieHolder>(){

    private var dataList = emptyList<ProductsEntityItem>()

    fun updateListProducts(mDataList: List<ProductsEntityItem>){

        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class TaskWieHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val mid = itemView.tv_id
        val mimage = itemView.imageProducts
        val mNombre = itemView.Nombre
        val mPrecio = itemView.Precio
        val itemView = itemView.setOnClickListener(this)

        override fun onClick(p0: View?) {

            mPassProducts.passProdcuts(dataList[adapterPosition])

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskWieHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.products, parent, false)
        return TaskWieHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskWieHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    interface Products{

        fun passProdcuts(mProducts: ProductsEntityItem)
    }

}