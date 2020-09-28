package com.example.postapp.Api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var client=OkHttpClient.Builder().build()
    var retrofit=Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .baseUrl("https://jsonplaceholder.typicode.com/todos")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> buildService(service:Class<T>):T{
        return retrofit.create(service)
    }

}