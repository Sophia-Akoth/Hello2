package com.example.postapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CommentsActivity : AppCompatActivity() {
    var postId:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        postId = intent.getIntExtra("POST_ID" ,0)
    }
}