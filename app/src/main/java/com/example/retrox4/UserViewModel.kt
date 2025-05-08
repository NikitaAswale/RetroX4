package com.example.retrox4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    val userRepository = UserRepository()

    private val _users = MutableStateFlow<List<UserDataClass>>(emptyList())
    val users: StateFlow<List<UserDataClass>> = _users.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers(){
        viewModelScope.launch {
            val response = userRepository.getUsers()

            if(response.isSuccessful){
                _users.value = response.body()!!
            }
        }
    }
}