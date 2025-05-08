package com.example.retrox4

import retrofit2.Response

class UserRepository {

    val apiService = APIService()

    suspend fun getUsers() : Response<List<UserDataClass>> {
        return apiService.userService.getUser()
    }
}