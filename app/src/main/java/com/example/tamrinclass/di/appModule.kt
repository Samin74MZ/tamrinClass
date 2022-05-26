package com.example.tamrinclass.di

import com.example.tamrinclass.data.User.UserLocalDataSource
import com.example.tamrinclass.data.User.UsersRepository
import com.example.tamrinclass.data.network.BASE_URL
import com.example.tamrinclass.ui.LoginViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    single {
        UsersRepository(get(),get())
    }
    single {
        UserLocalDataSource()
    }
    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
        retrofit
    }
  viewModel { LoginViewModel(get()) }
}