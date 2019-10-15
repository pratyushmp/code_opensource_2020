package com.example.androidarch.ui.auth

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.androidarch.data.repository.UserRepository
import com.example.androidarch.util.ApiException
import com.example.androidarch.util.Coroutines
import com.example.androidarch.util.NoInternetException

class AuthViewModel(

    private val repository: UserRepository
): ViewModel() {

    var name: String? = null
    var email: String? = null
    var password: String? = null
    var confirmPassword: String? = null
    var authListener: AuthListener? = null


    fun getLoggedInUsers() = repository.getUser()

    fun onLoginButtonClicked(view: View){
        authListener?.onStarted()
        if(email.isNullOrEmpty() || password.isNullOrEmpty()){

            authListener?.onFailure("Invalid Email or Password")
            return
        }

       Coroutines.main {

           try {
               val authResponse = repository.userLogin(email!!, password!!)

               authResponse.user?.let {
                   authListener?.onSucess(it)
                   repository.safeUser(it)
                   return@main
               }
               authListener?.onFailure(authResponse.message!!)
           }catch (e: ApiException){
               authListener?.onFailure(e.message!!)
           }catch (e: NoInternetException){
               authListener?.onFailure(e.message!!)
           }

       }
    }

    fun onSignUpButtonClicked(view: View){
        authListener?.onStarted()

        if(name.isNullOrEmpty()){
            authListener?.onFailure("Name is required")
            return
        }

        if(email.isNullOrEmpty()){

            authListener?.onFailure("Email is required")
            return
        }

        if(password.isNullOrEmpty()){
            authListener?.onFailure("Password is required")
            return
        }

        if (password != confirmPassword){
            authListener?.onFailure("Password Mismatch")
        }

        Coroutines.main {

            try {
                val authResponse = repository.userSignUp(name!!,email!!, password!!)

                authResponse.user?.let {
                    authListener?.onSucess(it)
                    repository.safeUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authListener?.onFailure(e.message!!)
            }

        }
    }

    fun onSignUp(view:View){
        Intent(view.context, SignUpActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun onLogin(view: View){
        Intent(view.context, LoginActivity::class.java).also {
            view.context.startActivity(it)
        }
    }
}