package com.example.tamrinclass.data.User

import com.example.tamrinclass.model.User

class UserRemoteDataSource {
    fun getUser(): User {
        return User(1,"kamran")
    }
}