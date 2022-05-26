package com.example.tamrinclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tamrinclass.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val loginViewModel: LoginViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}