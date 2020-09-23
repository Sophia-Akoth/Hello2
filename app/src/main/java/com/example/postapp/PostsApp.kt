package com.example.postapp

import android.app.Application
import android.content.Context

class PostsApp :Application(){
    override fun onCreate(){
        super.onCreate()
        PostsApp.appContext=applicationContext
    }
    companion object{
        lateinit var appContext: Context
    }
}