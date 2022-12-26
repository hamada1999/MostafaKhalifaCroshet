package com.example.mostafakhalifacroshet.models

import com.example.mostafakhalifacroshet.models.User
import com.example.mostafakhalifacroshet.utils.UserType

class Moderator(id: String?, name: String?, mail: String?, password: String? , userType: UserType) : User(
    id!!, name!!, mail!!, password!! , userType!!
)