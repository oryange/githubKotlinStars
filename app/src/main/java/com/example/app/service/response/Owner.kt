package com.example.app.service.response

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url") val image: String,
    @SerializedName("login") val author: String
)
