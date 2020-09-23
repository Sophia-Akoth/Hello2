package com.example.postapp.Repository

import androidx.lifecycle.LiveData
import com.example.postapp.Api.ApiClient
import com.example.postapp.Api.ApiInterface
import com.example.postapp.Database.PostAppDatabase
import com.example.postapp.Models.Post
import com.example.postapp.PostsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class PostRepository {
    suspend fun getPosts():Response<List<Post>> = withContext(Dispatchers.IO) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getPosts()
        if (response.isSuccessful) {
            val post=response.body()as List<Post>
            savePosts(posts)
        }
        return@withContext response
    }
    suspend fun savePosts(postsList: List<Post>)= withContext(Dispatchers.IO){
        val database=PostAppDatabase.getDbInstance(PostsApp.appContext)
        postsList.forEach { post -> database.postDao().insertPost(post) }
    }
}
fun getDbPosts():LiveData<List<Post>>{
    val database=PostAppDatabase.getDbInstance(PostsApp.appContext)
    return database.postDao().getPosts()
}
