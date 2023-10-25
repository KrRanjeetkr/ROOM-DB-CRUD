package com.example.roomdbcrud

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdbcrud.Room.AppDatabase
import com.example.roomdbcrud.Room.UserDao
import com.example.roomdbcrud.Room.UserTable
import com.example.roomdbcrud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        database = AppDatabase.getDatabase(this)
        userDao = database.myDao()

        getData()

        binding.insertBtn.setOnClickListener {
            var myTable = UserTable(0, binding.userName.text.toString(), binding.userEmail.text.toString())
                userDao.createUser(myTable)
            getData()

        }

    }

    private fun getData() {
        var usersList = userDao.getAllUser()

        var adapter = MyAdapter(this, usersList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}