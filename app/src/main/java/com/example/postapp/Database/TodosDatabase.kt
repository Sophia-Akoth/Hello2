package com.example.postapp.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.postapp.Models.Todos

abstract class TodosDatabase: RoomDatabase(){
    abstract fun Todos():PostsDao

    companion object{
        private var dbInstance:TodosDatabase?=null
        fun getDbInstance(context: Context):TodosDatabase{
            if(dbInstance==null){
                dbInstance= Room.databaseBuilder(context,TodosDatabase::class.java,"todosapp-db").build()
            }
            return dbInstance as TodosDatabase
        }
    }
}