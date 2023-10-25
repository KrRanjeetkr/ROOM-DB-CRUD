package com.example.roomdbcrud.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun createUser(userTable: UserTable)

    @Update
    fun updateUser(userTable: UserTable)

    @Query("SELECT * from user")
    fun getAllUser():List<UserTable>

    @Delete
    fun deleteUser(userTable: UserTable)


}