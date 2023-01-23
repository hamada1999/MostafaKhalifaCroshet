package com.example.mostafakhalifacroshet.data

import com.example.mostafakhalifacroshet.models.RemoteDatabase

class ShoppingCart(var id : String = "" , var productsList : MutableList<Product> = ArrayList<Product>()){


    fun deleteItem(product : Product){
        productsList.remove(product)
    }

    fun addItem(product: Product){
        productsList.add(product)
    }
}
