package com.example.postapp.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import java.math.MathContext
import java.security.AccessControlContext

abstract class PostAppDatabase:RoomDatabase() {
    abstract fun postDao():PostsDao

    companion object{
        private var dbInstance:PostAppDatabase?=null
        fun getDbInstance(context: Context):PostAppDatabase{
            if(dbInstance==null){
                dbInstance=Room.databaseBuilder(context,PostAppDatabase::class.java,"postapp-db").build()
            }
            return dbInstance as PostAppDatabase
        }
    }
}