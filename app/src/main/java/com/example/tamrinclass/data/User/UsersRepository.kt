package com.example.tamrinclass.data.User

import com.example.tamrinclass.model.User

class UsersRepository(
    val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource) {

    private lateinit var user: User

    suspend fun register(user:User):User{
        this.user =userRemoteDataSource.register(user)
        return this.user
    }
    suspend fun getUser(id:String,password:String):Boolean{
        var login=false
        userRemoteDataSource.getUser(id).let {
            if(it.password==password){
                this.user=it
                login=true
            }
        }
        return login
    }
}