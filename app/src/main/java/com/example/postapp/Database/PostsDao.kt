package com.example.postapp.Database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.postapp.Models.Post

@Dao
interface PostsDao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    fun insertPost(post:Post)
    @Query("SELECT * FROM posts")

}