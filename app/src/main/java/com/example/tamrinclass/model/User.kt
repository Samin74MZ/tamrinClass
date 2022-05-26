package com.example.tamrinclass.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "id") val id: String="0",
    @Json(name = "name") val name: String,
    @Json(name = "avatar") val avatarUrl: String,
    @Json(name = "password") val password: String,
    @Json(name = "status") val status: String
)
enum class Status{NEW_USER, Working}
enum class ApiState{LOADING,DONE}