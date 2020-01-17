package com.example.demomvvm.data.network

import com.example.demomvvm.data.network.responses.AuthResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface DummyApi {

    @FormUrlEncoded
    @POST("user_sessions")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ) : Response<AuthResponse>

    companion object {
        operator fun invoke() : DummyApi {
            return Retrofit.Builder()
                .baseUrl("http://172.18.0.1:3000/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(DummyApi::class.java)
        }
    }
}