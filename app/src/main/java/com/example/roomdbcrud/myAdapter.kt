package com.example.roomdbcrud

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbcrud.Room.AppDatabase
import com.example.roomdbcrud.Room.UserTable
import com.example.roomdbcrud.databinding.ItemLayoutBinding

class MyAdapter(private var context: Context, private var userList: List<UserTable>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
      return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item : UserTable = userList[position]
        holder.bindView(item)
    }

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindView(item: UserTable) {

            binding.userNameTv.text = item.userName
            binding.userEmailTv.text = item.userEmail

            binding.root.setOnClickListener {
                val intent = Intent(context, UpdateActivity::class.java)
                intent.putExtra("id", item.id)
                intent.putExtra("name", item.userName)
                intent.putExtra("email", item.userEmail)
                context.startActivity(intent)
            }

            binding.deleteUser.setOnClickListener {
                val database = AppDatabase.getDatabase(context)
                val dao = database.myDao()
                dao.deleteUser(item)
//                notifyDataSetChanged()
//                notifyItemRemoved(position)
            }

        }

    }

}