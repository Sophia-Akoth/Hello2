package com.example.postapp.Api

import com.example.postapp.Models.Post
import com.example.postapp.Models.Todos
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
    @GET("todos)
    suspend fun getTodos():Response<List<Todos>>
}