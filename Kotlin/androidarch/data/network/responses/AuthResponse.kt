package com.example.androidarch.data.network.responses

import com.example.androidarch.data.db.entities.User

data class AuthResponse (

    val isSucessful: Boolean?,
    val message: String?,
    val user: User?
)