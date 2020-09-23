package com.example.postapp.ViewModel

import androidx.lifecycle.MutableLiveData
import com.example.postapp.Models.Post

class PostViewModel (val postRepository:PostsRepository):ViewModel(){
    var postsLiveData=MutableLiveData<Post>()
    var postsFailedLiveData= MutableLiveData<String>()
    fun getApiPosts(){
        viewModelScope.launch{
            val response=postsRepository.getPosts()
            if(!response.isSuccesful){
                postsLiveData.postValue(response.errorBody()?.string())
            }

        }
    }
    fun getDbPosts(){
        postsLiveData = postsRepository.getDbPosts()
    }
}