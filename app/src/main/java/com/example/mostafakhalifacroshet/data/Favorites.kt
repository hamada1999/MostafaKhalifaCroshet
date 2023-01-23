package com.example.mostafakhalifacroshet.data

class Favorites(var id: String = "") {
    var favoriteProducts : MutableList<Product> = ArrayList<Product>()

    fun addFavoriteItem(product: Product){
        favoriteProducts.add(product)
    }

    fun removeFavoriteItem(product: Product){
        favoriteProducts.remove(product)
    }
}