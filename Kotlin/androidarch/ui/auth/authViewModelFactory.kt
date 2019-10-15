package com.example.androidarch.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarch.data.repository.UserRepository

@Suppress("UNCHECKED_CAST")
class authViewModelFactory(
   private val userRepository: UserRepository
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(userRepository) as T
    }
}