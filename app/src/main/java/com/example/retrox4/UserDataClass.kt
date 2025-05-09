package com.example.retrox4

data class UserDataClass(
    val name : String,
    val username : String,
    val email : String,
    val address : Address,
    val company : Company,
)

data class Address(
    val city : String,
)

data class Company(
    val name : String,
)

