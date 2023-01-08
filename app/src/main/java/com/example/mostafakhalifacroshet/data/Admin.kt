package com.example.mostafakhalifacroshet.viewModels

import com.example.mostafakhalifacroshet.models.User
import com.example.mostafakhalifacroshet.utils.UserType

class Admin(id: String?, name: String?, mail: String?, password: String? , userType: UserType) : User(
    id!!, name!!, mail!!, password!! , userType!!
)