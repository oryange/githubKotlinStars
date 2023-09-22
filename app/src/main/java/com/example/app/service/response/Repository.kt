package com.example.app.service.response

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("full_name") val name: String,
    @SerializedName("stargazers_count") val stargazersCount: Int,
    @SerializedName("forks_count") val forksCount: Int,
    @SerializedName("owner") val owner: Owner
)
