package com.example.androidarch.ui.auth

import androidx.lifecycle.LiveData
import com.example.androidarch.data.db.entities.User

interface AuthListener {

    fun onStarted()
    fun onSucess(user:User)
    fun onFailure(message: String)
}