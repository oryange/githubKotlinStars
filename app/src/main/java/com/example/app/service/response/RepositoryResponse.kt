package com.example.app.service.response

import com.google.gson.annotations.SerializedName

data class RepositoryResponse(
    @SerializedName("items") val items: List<RepositoryItem>
)
