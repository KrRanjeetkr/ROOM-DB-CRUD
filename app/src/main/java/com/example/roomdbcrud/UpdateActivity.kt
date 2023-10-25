package com.example.roomdbcrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdbcrud.Room.AppDatabase
import com.example.roomdbcrud.Room.UserDao
import com.example.roomdbcrud.Room.UserTable
import com.example.roomdbcrud.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityUpdateBinding.inflate(layoutInflater)
    }

    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val id = intent.getIntExtra("id", -1)
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")

        database= AppDatabase.getDatabase(this)
        userDao= database.myDao()

        binding.userName.setText(name)
        binding.userEmail.setText(email)

        binding.updateBtn.setOnClickListener {
            userDao.updateUser(UserTable(id, binding.userName.text.toString(), binding.userEmail.text.toString()))
            finish()

        }

    }
}