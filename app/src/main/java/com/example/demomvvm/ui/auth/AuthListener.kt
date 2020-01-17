package com.example.demomvvm.ui.auth

interface AuthListener {
    fun onStarted()
    fun onSuccess(loginResponse: String)
    fun onFailure(message: String)
}