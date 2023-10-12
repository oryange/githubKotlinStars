package com.example.app.data.dto

import com.google.gson.annotations.SerializedName

data class OwnerDto(
    @SerializedName("avatar_url") val image: String,
    @SerializedName("login") val author: String
)
