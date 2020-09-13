package com.example.postapp.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.postapp.R
import com.example.postapp.Repository.PostRepository
import com.example.postapp.ViewModel.PostViewModel
import com.example.postapp.ViewModel.PostsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var postViewModel: PostViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val postRepository=PostRepository()
        postsViewModelFactory=PostsViewModelFactory(postRepository)
        postViewModel=
            ViewModelProvider(this,postsViewModelFactory).get(PostViewModel::class.java)
        postViewModel.getPosts()

        postsViewModel.postsLiveData.observe(this,{postsList->
            Toast.makeText(baseContext,"${postsList.size} posts fetched",Toast.LENGTH_LONG.show())
        })
        postsViewModel.postsFailedLiveData.observe(this,{error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
        rvPosts.layoutManager = LinearLayoutManager(baseContext)
        val namesAdapter = NamesRecyclerViewAdapter(listOf("User id","id","title","body"))
        rvPosts.adapter = namesAdapter
    }
}