package com.example.mostafakhalifacroshet.data

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.example.mostafakhalifacroshet.models.RemoteDatabase
import com.example.mostafakhalifacroshet.utils.TAG
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductRepository(val app : Application) {
   val productDataList = MutableLiveData<List<Product>>()
   private val remoteDatabase  = RemoteDatabase().getInstance()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getRemoteProductsData()
        }
    }

    @WorkerThread
    fun getRemoteProductsData() {
        remoteDatabase.getDatabaseRef("Products").child("COTTON")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<Product>()
                    for (product in snapshot.children){
                        val value = product.getValue<Product>()
                        list.add(value!!)
                    }
                    productDataList.postValue(list)
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.w(TAG, "Failed to read value.", error.toException())
                }
            })
    }

    @Suppress("DEPRECATION")
    private fun isNetworkAvailable() : Boolean{
        val connectivityManager = app.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnectedOrConnecting ?: false
    }
}