package com.example.products.model.MyViewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.products.model.ui.FirstFragment
import com.example.products.R
import com.example.products.model.room.ProductsItem
import kotlinx.android.synthetic.main.products.view.*

class ProductsAdapter(var mPassProducts: FirstFragment): RecyclerView.Adapter<ProductsAdapter.TaskWieHolder>(){

    private var dataList = emptyList<ProductsItem>()

    fun updateListProducts(mDataList: List<ProductsItem>){

        dataList = mDataList
        notifyDataSetChanged()
    }

    inner class TaskWieHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{


        val mimage = itemView.imageProducts
        val mNombre = itemView.Name
        val mPrecio = itemView.Price
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

        val products1: ProductsItem = dataList[position]
        holder.mNombre.text = products1.name.capitalize()
        holder.mPrecio.text = products1.price.toString()
        Glide.with(holder.itemView.context)
            .load(products1.image)
            .into(holder.mimage)
    }

    override fun getItemCount() = dataList.size



    interface Products{

        fun passProdcuts(mProducts: ProductsItem)
    }

}