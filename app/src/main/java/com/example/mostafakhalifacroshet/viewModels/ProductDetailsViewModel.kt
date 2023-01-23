package com.example.mostafakhalifacroshet.viewModels

import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mostafakhalifacroshet.data.Product
import com.example.mostafakhalifacroshet.data.ShoppingCart
import com.example.mostafakhalifacroshet.models.RemoteDatabase
import com.example.mostafakhalifacroshet.utils.PRODUCTLIST_PREFERENCE
import com.example.mostafakhalifacroshet.utils.SHOPPINGCART_REFERENCE
import com.google.firebase.auth.FirebaseUser

class ProductDetailsViewModel() : ViewModel() , Observable {

    var remoteDatabase = RemoteDatabase().getInstance()
    val userId = remoteDatabase.getUserUid()
    lateinit var Iproduct : Product

    @Bindable
    var productName = MutableLiveData<String>()

    @Bindable
    var productPrice = MutableLiveData<String>()

    @Bindable
    var productDesc = MutableLiveData<String>()

    @Bindable
    var productImageSrc = MutableLiveData<String>()


    fun onClickAddToCartBtn(){
        remoteDatabase.getDatabaseRef(SHOPPINGCART_REFERENCE)
            .child(userId).child(PRODUCTLIST_PREFERENCE).push().setValue(Iproduct)
    }

    fun onClickBackBtn(){

    }

    fun setProductData(){
        if(Iproduct != null) {
            productName.value = Iproduct.name
            productPrice.value = Iproduct.price.toString()
            productDesc.value = Iproduct.desc
            productImageSrc.value = Iproduct.imageId
        }
    }

    fun setProduct(product: Product){
        Iproduct = product
    }


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}