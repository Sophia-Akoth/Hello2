package com.example.postapp.ViewModel

import androidx.lifecycle.ViewModel
import com.example.postapp.Repository.PostRepository

class PostsViewModelFactory(val postRepository: PostRepository):viewModelProvider.Factory {
    override fun <T:ViewModel?>create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(PostViewModel::class.java)){
            return PostViewModel(postRepository) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}