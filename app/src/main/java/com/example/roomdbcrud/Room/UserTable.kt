package com.example.roomdbcrud.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
 data class UserTable(

    @PrimaryKey(autoGenerate = true)
     var id: Int,
     var userName:String,
     var userEmail:String

)
