package com.example.mostafakhalifacroshet.models

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mostafakhalifacroshet.utils.userType
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RemoteDatabase {
    private val database = Firebase.database.reference
    private lateinit var myRef : DatabaseReference
    private var auth = Firebase.auth
    private var fUser = auth.currentUser

    private val _successAuth = MutableLiveData<Boolean>()
    val successAuth : LiveData<Boolean>
        get() = _successAuth


    fun getDatabaseRef(ref : String) : DatabaseReference {
        myRef = database.child(ref)
        return myRef
    }

    fun userAuth(mail : String , pass : String){
        auth.createUserWithEmailAndPassword(mail , pass)
            .addOnCompleteListener {
                if(it.isSuccessful)
                    Log.d("testing", "createUserWithEmail:success")
                else{
                    Log.w("testing", "createUserWithEmail:failure", it.exception)
                }
            }
    }

    fun signInUser(mail : String , pass : String){
        auth.signInWithEmailAndPassword(mail , pass)
            .addOnCompleteListener {
                if(it.isSuccessful) {
                    Log.d("testing", "SignInWithEmail: Success")
                    _successAuth.value = true
                }
                else {
                    Log.d("testing", "SignInWithEmail: Failure")
                    _successAuth.value = false
                }
            }
    }

    fun registerNewUser(user : Any?){
        fUser?.let {
            Firebase.database.reference.child("Users").child(userType.toString()).child(it.uid).setValue(user)
                .addOnCompleteListener(OnCompleteListener {
                    if(it.isSuccessful)
                        Log.d("testing", "user registered successfully!")
                })
        }
    }

    fun getUserUid() : String {
        return fUser?.uid ?: ""
    }

}