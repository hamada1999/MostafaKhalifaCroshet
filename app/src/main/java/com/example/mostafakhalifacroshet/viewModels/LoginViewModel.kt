package com.example.mostafakhalifacroshet.viewModels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mostafakhalifacroshet.models.RemoteDatabase

class LoginViewModel : ViewModel() , Observable{

    private var remoteDatabase = RemoteDatabase()

    @Bindable
    var inputMail = MutableLiveData<String>()
    @Bindable
    var inputPass = MutableLiveData<String>()

    private val _errorMailInput = MutableLiveData<Boolean>()
    val errorMailInput : LiveData<Boolean>
        get() = _errorMailInput

    private val _errorPassInput = MutableLiveData<Boolean>()
    val errorPassInput : LiveData<Boolean>
        get() = _errorPassInput

    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome : LiveData<Boolean>
        get() = _navigateToHome

    private val _navigateToSignUp = MutableLiveData<Boolean>()
    val navigateToSignUp : LiveData<Boolean>
        get() = _navigateToSignUp


    fun signInButton(){
        if(!isEmailValid(inputMail.value?:""))
            _errorMailInput.value = true
        if(inputPass.value?.length ?: 0 <= 0)
            _errorPassInput.value = true
        if(errorMailInput.value != false && errorPassInput.value != false){
            remoteDatabase.signInUser(inputMail.value ?: "noValidEmail" , inputPass.value ?: "noValidPassword")
            if(remoteDatabase.successAuth.value == true)
                _navigateToHome.value = true
        }
    }

    fun signUpButton(){
        _navigateToSignUp.value = true
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    private fun isEmailValid(email : String) : Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}