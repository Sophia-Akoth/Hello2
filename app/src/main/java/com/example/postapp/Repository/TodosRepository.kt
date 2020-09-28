package com.example.postapp.Repository

import androidx.lifecycle.LiveData
import com.example.postapp.Api.ApiClient
import com.example.postapp.Api.ApiInterface
import com.example.postapp.Database.PostAppDatabase
import com.example.postapp.Models.Post
import com.example.postapp.Models.Todos
import com.example.postapp.PostsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class TodosRepository {
    suspend fun getTodos(): Response<List<Todos>> = withContext(Dispatchers.IO) {
        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val response = apiClient.getTodos()
        if (response.isSuccessful) {
            val post=response.body()as List<Todos>
            savePosts(Todos)
        }
        return@withContext response
    }
    suspend fun saveTodos(postsList: List<Post>)= withContext(Dispatchers.IO){
        val database= PostAppDatabase.getDbInstance(PostsApp.appContext)
        postsList.forEach { post -> database.postDao().insertPost(post) }
    }
}
fun getDbTodos(): LiveData<List<Post>> {
    val database= PostAppDatabase.getDbInstance(PostsApp.appContext)
    return database.postDao().getTodos()
}
}