package com.example.androidarch.data.network

import com.example.androidarch.data.network.responses.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email")email:String,
        @Field("password") password:String
    ): Response<AuthResponse>

    @FormUrlEncoded
    @POST("login")
    suspend fun userSignUp(
        @Field("name")name:String,
        @Field("email")email:String,
        @Field("password") password:String
    ): Response<AuthResponse>


    companion object{
        operator fun invoke(
            newConnectionInterceptor: NetworkConnectionInterceptor
        ):MyApi{

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(newConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.simplifiedcoding.in/course-apis/mvvm/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}