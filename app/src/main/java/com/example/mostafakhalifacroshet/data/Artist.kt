package com.example.mostafakhalifacroshet.data

import com.example.mostafakhalifacroshet.models.Gender
import com.example.mostafakhalifacroshet.utils.UserType

class Artist(
    id: String?, name: String?, mail: String?, password: String?, userType: UserType,
    var phone: String, var address: String, var gender: String, var age: String
) : User(
    id!!, name!!, mail!!, password!! , userType!!
)