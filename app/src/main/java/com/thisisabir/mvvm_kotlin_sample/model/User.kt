package com.thisisabir.mvvm_kotlin_sample.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("id") val id : Int,
    @SerializedName("image") val image : String,
    @SerializedName("name") val name : String,
    @SerializedName("designation") val designation : String,
    @SerializedName("email") val email : String,
    @SerializedName("phone") val phone : String,
    @SerializedName("section") val section : String
)



