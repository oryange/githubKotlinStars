package com.example.app.data.dto

import com.google.gson.annotations.SerializedName

data class RepositoryDto(
    @SerializedName("items") val items: List<RepositoryItemDto>
)
