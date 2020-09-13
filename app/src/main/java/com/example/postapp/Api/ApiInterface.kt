package com.example.postapp.Api

import com.example.postapp.Models.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}