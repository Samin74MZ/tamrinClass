package com.example.tamrinclass.di

import com.example.tamrinclass.data.User.UserLocalDataSource
import com.example.tamrinclass.data.User.UserRemoteDataSource
import com.example.tamrinclass.data.User.UsersRepository
import com.example.tamrinclass.data.network.ApiService
import com.example.tamrinclass.data.network.BASE_URL
import com.example.tamrinclass.data.network.client
import com.example.tamrinclass.ui.ui.LoginViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
        retrofit
    }

    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(ApiService::class.java)

        loginApiService
    }
    single {
        UserLocalDataSource()
    }
    single {
        UserRemoteDataSource(get())
    }
    single {
        UsersRepository(get(), get())
    }
    viewModel { LoginViewModel(get()) }
  //  viewModel { RegisterViewModel(get()) }

}