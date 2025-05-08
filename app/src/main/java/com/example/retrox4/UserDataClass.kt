package com.example.retrox4

data class UserDataClass(
    val id : Int,
    val name : String,
    val username : String,
    val email : String,
    val address : Address,
    val company : Company,
    val phone : Int,
    val website : String
)

data class Address(
    val street : String,
    val suite : String,
    val city : String,
    val zipcode : Int,
    val geo : Geo
)

data class Geo(
    val lat : Int,
    val Ing : Int
)

data class Company(
    val name : String,
    val ctchPhrase : String,
    val bs : String
)

