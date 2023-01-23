package com.example.mostafakhalifacroshet.data

import com.example.mostafakhalifacroshet.models.OrderState

class Order(var id: String, var address: String = "" , var phone: String){
    var productsList : List<Product> = ArrayList<Product>()
    var isOrderCanceled : Boolean = false
    var orderState : OrderState = OrderState.UNDEFINED

    fun cancelOrder(){
        isOrderCanceled = true
        orderState = OrderState.CANCELED
    }

    fun trackOrder() : OrderState {
        return orderState
    }

}
