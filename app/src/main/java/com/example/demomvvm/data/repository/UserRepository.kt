package com.example.demomvvm.data.repository

import android.util.Log
import com.example.demomvvm.data.network.DummyApi
import com.example.demomvvm.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return DummyApi().userLogin(email, password)
    }
}