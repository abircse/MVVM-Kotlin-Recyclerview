package com.thisisabir.mvvm_kotlin_sample.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thisisabir.mvvm_kotlin_sample.model.User
import com.thisisabir.mvvm_kotlin_sample.repository.MainActivityRepository

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    // call repository class by object
    private val repository: MainActivityRepository = MainActivityRepository(application)

    //call repository method call alluserdata
    fun getalluserData(): LiveData<List<User>> {

        return repository.getUserData()!!
    }


}