package com.example.tamrinclass.data.User

import com.example.tamrinclass.model.User
import com.example.tamrinclass.data.network.ApiService as ApiService

class UserRemoteDataSource(private val loginApiService:ApiService) {

  suspend fun register(user:User):User{
     return loginApiService.register(user)
  }

    suspend fun getUser(id:String):User{
        return loginApiService.getUser(id)
    }
}