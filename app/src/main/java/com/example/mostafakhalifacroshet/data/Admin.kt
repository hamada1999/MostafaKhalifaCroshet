package com.example.mostafakhalifacroshet.data

import com.example.mostafakhalifacroshet.data.User
import com.example.mostafakhalifacroshet.utils.UserType

class Admin(id: String?, name: String?, mail: String?, password: String? , userType: UserType) : User(
    id!!, name!!, mail!!, password!! , userType!!
)