package com.example.mostafakhalifacroshet.models

import com.example.mostafakhalifacroshet.utils.UserType

class Artist(
    id: String?, name: String?, mail: String?, password: String?, userType: UserType,
    var phone: String, var address: String, var gender: Gender, var age: Int
) : User(
    id!!, name!!, mail!!, password!! , userType!!
)