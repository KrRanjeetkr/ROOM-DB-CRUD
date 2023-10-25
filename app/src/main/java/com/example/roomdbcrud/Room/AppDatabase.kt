package com.example.roomdbcrud.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserTable::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun myDao(): UserDao

    companion object{
        private var INSTANCE:AppDatabase?=null
        fun getDatabase(context: Context) : AppDatabase{

            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!

        }
    }

}