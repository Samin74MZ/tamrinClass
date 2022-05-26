package com.example.tamrinclass.data.network

import com.example.tamrinclass.model.User
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


val logger =HttpLoggingInterceptor().apply { level= HttpLoggingInterceptor.Level.BASIC }

val client=OkHttpClient.Builder()
    .addInterceptor(logger)
    .build()

const val BASE_URL = "https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService{
    @POST("users")
    suspend fun  register(@Body user : User): User

    @GET("users/{id}")
    suspend fun getUser(@Path("id") id:String):User
}