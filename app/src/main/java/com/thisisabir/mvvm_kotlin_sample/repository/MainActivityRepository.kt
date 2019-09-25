package com.thisisabir.mvvm_kotlin_sample.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import com.thisisabir.mvvm_kotlin_sample.model.User
import java.util.*

class MainActivityRepository(private val application: Application) {

    // variable declaration
    private val url = "http://www.coxtunes.com/client_mobile_app_project/education/cbiu/api/administration.php"
    private var mutableLiveData: MutableLiveData<List<User>>? = null
    private lateinit var userList: List<User>

    fun getUserData(): MutableLiveData<List<User>>? {

        if (mutableLiveData ==null)
        {
            mutableLiveData = MutableLiveData()
        }

        val request = StringRequest(Request.Method.POST, url, Response.Listener { response ->
                val gsonBuilder = GsonBuilder()
                val gson = gsonBuilder.create()
                userList = listOf(*gson.fromJson(response, Array<User>::class.java))
                mutableLiveData!!.value = userList
            }, Response.ErrorListener { })
        val rQueue = Volley.newRequestQueue(application)
        rQueue.add(request)

        return mutableLiveData

    }


}


