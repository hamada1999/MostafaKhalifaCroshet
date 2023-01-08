package com.example.mostafakhalifacroshet.data

import com.example.mostafakhalifacroshet.models.ProductType

data class Product(var productType: ProductType = ProductType.COTTON, var code : String = "", var name: String = ""
                   , var price: Int = 0 , var imageId: String = "", var rate : Float= 0.0f, var quantity : Int = 0){

}