package com.thisisabir.mvvm_kotlin_sample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.thisisabir.mvvm_kotlin_sample.R
import com.thisisabir.mvvm_kotlin_sample.model.User

class UserAdapter(val userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.name.text = userList[position].name
        holder.designation.text = userList[position].designation

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name = itemView.findViewById(R.id.textView1) as TextView
        val designation = itemView.findViewById(R.id.textView2) as TextView

    }

}