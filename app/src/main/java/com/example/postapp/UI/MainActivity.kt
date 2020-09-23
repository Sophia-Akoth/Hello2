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
        postViewModel.getDbPosts()

        postsViewModel.postsLiveData.observe(this,{postsList->
            if (posts.isEmpty()){
                postsViewModel.getApiPosts()
            }
            else{
                rvPosts.layoutManager = LinearLayoutManager(baseContext)
                val postAdapter = NamesRecyclerViewAdapter(posts)
                rvPosts.adapter = postAdapter

            }

            Toast.makeText(baseContext,"${postsList.size} posts fetched",Toast.LENGTH_LONG.show())
        })
        postsViewModel.postsFailedLiveData.observe(this,{error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })

    }
}