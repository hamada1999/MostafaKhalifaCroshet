package com.example.mostafakhalifacroshet.viewModels

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mostafakhalifacroshet.data.*
import com.example.mostafakhalifacroshet.models.RegisterRepository
import com.example.mostafakhalifacroshet.models.RemoteDatabase
import com.example.mostafakhalifacroshet.utils.UserType
import com.example.mostafakhalifacroshet.utils.userType

class RegisterViewModel() : ViewModel()  , Observable  {

    var registerRepository = RegisterRepository()
    private var remoteDatabase = RemoteDatabase().getInstance()

    @Bindable
    var inputName = MutableLiveData<String>()

    @Bindable
    var inputMail = MutableLiveData<String>()

    @Bindable
    var inputPass = MutableLiveData<String>()

    @Bindable
    var inputAddress = MutableLiveData<String>()

    @Bindable
    var inputPhone = MutableLiveData<String>()

    @Bindable
    var inputAge = MutableLiveData<String>()

    @Bindable
    var inputGender = MutableLiveData<String>()


    private val _errorNameInput = MutableLiveData<Boolean>()
    val errorNameInput : LiveData<Boolean>
         get() = _errorNameInput

    private val _errorMailInput = MutableLiveData<Boolean>()
    val errorMailInput : LiveData<Boolean>
        get() = _errorMailInput

    private val _errorPassInput = MutableLiveData<Boolean>()
    val errorPassInput : LiveData<Boolean>
        get() = _errorPassInput

    private val _errorPhoneInput = MutableLiveData<Boolean>()
    val errorPhoneInput : LiveData<Boolean>
        get() = _errorPhoneInput

    private val _errorAgeInput = MutableLiveData<Boolean>()
    val errorAgeInput : LiveData<Boolean>
        get() = _errorAgeInput

    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome : LiveData<Boolean>
        get() = _navigateToHome

    private val _navigateToSignIn = MutableLiveData<Boolean>()
    val navigateToSignIn : LiveData<Boolean>
        get() = _navigateToSignIn


    fun signUpButton() {
        if(inputName.value?.length ?: 0 < 6)
            _errorNameInput.value = true
        var mail : String = inputMail.value ?: " "
        if(!isEmailValid(mail))
            _errorMailInput.value = true
        var phone : String = inputPhone.value ?: " "
        if(!isPhoneValid(phone))
            _errorPhoneInput.value = true
        if(inputPass.value?.length ?: 0 < 8)
            _errorPassInput.value = true
        var age : String = (inputAge.value ?: " ")
        if(age< 13.toString() || age > 85.toString())
            _errorAgeInput.value = true

        if(errorNameInput.value != false && errorMailInput.value != false && errorPassInput.value != false
            && errorAgeInput.value != false && errorPhoneInput.value != false) {
            registerUser()
            _navigateToHome.value = true
        }
    }

    fun signInButton() {
        _navigateToSignIn.value = true
    }

    fun registerUser() {
        remoteDatabase.userAuth(inputMail.value ?: " ",  inputPass.value?: " ")

        // check user Type
        if(userType == UserType.CUSTOMER){
            val user = Customer( remoteDatabase.getUserUid(),inputName.value ?: " " , inputMail.value?: " " , inputPass.value?: " " , userType
                , inputPhone.value ?: " ", inputAddress.value?: " ", inputGender.value?: " ", inputAge.value ?: " ")
            remoteDatabase.registerNewUser(user)
        }else if(userType == UserType.ARTIST){
            val user = Artist( remoteDatabase.getUserUid(),inputName.value ?: " " , inputMail.value?: " " , inputPass.value?: " " , userType
                , inputPhone.value ?: " ", inputAddress.value?: " ", inputGender.value?: " ", inputAge.value ?: " ")
            remoteDatabase.registerNewUser(user)
        }else if(userType == UserType.MODERATOR){
            val user = Moderator( remoteDatabase.getUserUid(),inputName.value ?: " " , inputMail.value?: " " , inputPass.value?: " " , userType)
            remoteDatabase.registerNewUser(user)
        }else if(userType == UserType.ADMIN){
            val user = Admin( remoteDatabase.getUserUid(),inputName.value ?: " " , inputMail.value?: " " , inputPass.value?: " " , userType)
            remoteDatabase.registerNewUser(user)
        }
    }

    private fun isEmailValid(email : String) : Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPhoneValid(phone : String) : Boolean {
        return android.util.Patterns.PHONE.matcher(phone).matches()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }


}

