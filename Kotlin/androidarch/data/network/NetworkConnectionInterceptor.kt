package com.example.androidarch.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.example.androidarch.util.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor (
    context : Context
): Interceptor{

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if(!isInternetAvailable())
            throw NoInternetException("no Internet connection detected")

        return chain.proceed(chain.request())

    }


    private fun isInternetAvailable(): Boolean{

        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.activeNetworkInfo.also {
             return it != null && it.isConnected
        }
    }
}