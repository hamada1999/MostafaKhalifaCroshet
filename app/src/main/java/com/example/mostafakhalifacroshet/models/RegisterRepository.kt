package com.example.mostafakhalifacroshet.models

import androidx.lifecycle.MutableLiveData
import com.example.mostafakhalifacroshet.data.Artist
import com.example.mostafakhalifacroshet.data.Customer
import com.example.mostafakhalifacroshet.data.Admin
import com.example.mostafakhalifacroshet.data.Moderator
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class RegisterRepository {
    val customerUsers = MutableLiveData<Customer>()
    val artistUsers = MutableLiveData<Artist>()
    val moderatorUsers = MutableLiveData<Moderator>()
    val adminUsers = MutableLiveData<Admin>()

    private val remoteDatabase = RemoteDatabase().getInstance()

    fun getCustomerUsers(){
        remoteDatabase.getDatabaseRef("Users/Customers")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for(data in snapshot.children){
                        val value : Customer = data.value as Customer
                    }
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })
    }

    fun getArtistUsers(){

    }

    fun getModeratorUsers(){

    }

    fun getAdminUsers(){

    }

    fun insertCustomerUser(user : Customer){

    }

    fun insertArtistUser(user : Artist){

    }

    fun insertModeratorUser(user : Moderator){

    }

    fun insertAdminUser(user : Admin){

    }

}