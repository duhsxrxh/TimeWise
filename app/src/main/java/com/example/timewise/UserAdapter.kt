package com.example.timewise

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val c:Context,val userList: ArrayList<String>): RecyclerView.Adapter<UserAdapter.userViewHolder>() {
    inner class userViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        val Name = v.findViewById<TextView>(R.id.txtCreateNewCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.category_file_display, parent, false)
        return userViewHolder(v)
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        val newList = userList[position]
        holder.Name.text = newList.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}