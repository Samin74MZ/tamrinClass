package com.example.tamrinclass.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tamrinclass.data.User.UsersRepository
import kotlinx.coroutines.launch

class LoginViewModel(var userRepository: UsersRepository) : ViewModel()  {
    val loginSuccessful = MutableLiveData<Boolean>()
    fun login(id: String, password: String) {
        viewModelScope.launch {
            try {
                loginSuccessful.value = userRepository.getUser(id, password)
            } catch (e: Exception) {
                loginSuccessful.value=false
                Log.d("TAG", "login:failed $e ")
            }
        }
    }
}