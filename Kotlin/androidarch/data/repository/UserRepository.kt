package com.example.androidarch.data.repository

import com.example.androidarch.data.db.AppDatabase
import com.example.androidarch.data.db.entities.User
import com.example.androidarch.data.network.MyApi
import com.example.androidarch.data.network.SafeApiRequest
import com.example.androidarch.data.network.responses.AuthResponse
import retrofit2.Response


class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase

): SafeApiRequest() {

    suspend fun userLogin(email:String, password:String): AuthResponse{

        return apiRequest{api.userLogin(email, password)}
    }

    suspend fun userSignUp(name:String, email:String, password:String): AuthResponse{

        return apiRequest{api.userSignUp(name, email, password)}
    }


    suspend fun safeUser(user: User) = db.getUserDao().updateOrInsert(user)

    fun getUser() = db.getUserDao().getUser()


}