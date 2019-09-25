package com.thisisabir.mvvm_kotlin_sample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.thisisabir.mvvm_kotlin_sample.adapter.UserAdapter
import com.thisisabir.mvvm_kotlin_sample.model.User
import com.thisisabir.mvvm_kotlin_sample.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        mainActivityViewModel.getalluserData().observe(this, Observer<List<User>> { users ->
                val adapter = UserAdapter(users)
                recyclerView.adapter = adapter
                // get specific data
                Toast.makeText(this@MainActivity, "" + users[0].name, Toast.LENGTH_SHORT).show()
            })



    }


}
