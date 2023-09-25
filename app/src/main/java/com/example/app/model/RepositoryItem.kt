package com.example.app.model

internal data class RepositoryItem(
    val id : Int,
    val name: String,
    val image: String,
    val author: String,
    val stargazersCount: Int,
    val forksCount: Int,
)
