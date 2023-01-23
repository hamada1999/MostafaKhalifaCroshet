package com.example.mostafakhalifacroshet.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mostafakhalifacroshet.R
import com.example.mostafakhalifacroshet.data.Product

class ProductsRecyclerAdapter(private val pList : List<Product>, private val context : Context) :
    RecyclerView.Adapter<ProductsRecyclerAdapter.ViewHolder>() {

    private lateinit var cartListener : Listener


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val productImg : ImageView = itemView.findViewById(R.id.product_img)
        val productName : TextView = itemView.findViewById(R.id.product_name)
        val productCategory : TextView = itemView.findViewById(R.id.category_txt)
        val productPrice : TextView = itemView.findViewById(R.id.product_price)
        val loveButton : ImageButton = itemView.findViewById(R.id.love_btn)
        val cartButton : ImageButton = itemView.findViewById(R.id.cart_btn)
        val ratingBar : RatingBar = itemView.findViewById(R.id.rating_bar)
    }

    interface Listener{
        fun onClick(position : Int)
    }

    fun setListener(listener : Listener){
        cartListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_layout, parent , false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = pList[position]

        Glide.with(context).load(itemView.imageId)
            .into(holder.productImg)
        holder.productName.text = itemView.name
        holder.productPrice.text = itemView.price.toString().trim()
        holder.productCategory.text = itemView.productType.toString().trim()
        holder.ratingBar.rating = itemView.rate
        /*
        holder.loveButton.setOnClickListener(View.OnClickListener {
            if(loveListener != null)
                loveListener.onClick(position)
        })
         */

        holder.cartButton.setOnClickListener(View.OnClickListener {
            cartListener.onClick(position)
        })
    }

    override fun getItemCount(): Int {
        return pList.size
    }
}