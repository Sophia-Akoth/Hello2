package com.example.postapp.Repository

import com.example.postapp.Api.ApiClient
import com.example.postapp.Api.ApiInterface
import com.example.postapp.Models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {
    suspend fun getPosts():Response<List<Post>> = withContext(Dispatchers.IO){
        val apiClient=ApiClient.buildService(ApiInterface::class.java)
        val response=apiClient.getPosts()
        return@withContext response
    }
}