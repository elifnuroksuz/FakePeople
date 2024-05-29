package com.elifnuroksuz.busonolsun.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.elifnuroksuz.busonolsun.R
import com.elifnuroksuz.busonolsun.databinding.ProductItemBinding
import com.elifnuroksuz.busonolsun.model.Product
import com.elifnuroksuz.busonolsun.util.downloadURL

class ProductAdapter (private var productList: ArrayList<Product>, private var onClick :(position : Int)->Unit): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    class ProductViewHolder(var view: ProductItemBinding): RecyclerView.ViewHolder(view.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ProductItemBinding>(inflater, R.layout.product_item,parent,false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.view.title.text = productList[position].name
        holder.view.price.text = productList[position].username

        holder.view.cvItem.setOnClickListener(){
              onClick(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun  updateList(newList: List<Product>){
        productList = newList as ArrayList<Product>
        notifyDataSetChanged()
    }
}


