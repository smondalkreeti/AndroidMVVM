package com.example.demomvvm.ui.auth

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.demomvvm.data.repository.UserRepository
import com.example.demomvvm.util.Coroutines

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null

    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener!!.onStarted()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            Log.d("click", "$authListener")
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            val response = UserRepository().userLogin(email!!, password!!)

            if (response.isSuccessful) {
                Log.d("successful response", "$response")
                authListener?.onSuccess(response.body().toString())
            }else{
                Log.d("error response", "$response")
                authListener?.onFailure("Error message: ${response.message()}")
            }
        }
    }
}