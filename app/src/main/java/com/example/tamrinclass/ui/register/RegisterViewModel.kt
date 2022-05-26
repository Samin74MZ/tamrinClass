package com.example.tamrinclass.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tamrinclass.data.User.UsersRepository
import com.example.tamrinclass.model.ApiState
import com.example.tamrinclass.model.User
import kotlinx.coroutines.launch

class RegisterViewModel (var userRepository: UsersRepository) : ViewModel() {
    val userId = MutableLiveData<String>()
    val state = MutableLiveData<ApiState>()
    fun registerUser(user: User) {
        viewModelScope.launch {
            state.value = ApiState.LOADING
            userId.value = userRepository.register(user).id
            state.value = ApiState.DONE
        }
    }
}