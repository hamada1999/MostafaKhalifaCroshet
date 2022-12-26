package com.example.mostafakhalifacroshet.models

import com.example.mostafakhalifacroshet.utils.UserType

class Customer(
    id: String?, name: String?, mail: String?, password: String?, userType: UserType?,
    var phone: String, var address: String, var gender: String, var age: String
) : User(
    id!!, name!!, mail!!, password!! , userType!!
)