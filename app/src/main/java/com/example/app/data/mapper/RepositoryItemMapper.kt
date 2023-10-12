package com.example.app.data.mapper

import com.example.app.data.dto.RepositoryDto
import com.example.app.domain.model.RepositoryItem

internal class RepositoryItemMapper {
    fun map(dto: RepositoryDto) : List<RepositoryItem> = dto.items.map { item ->
        RepositoryItem(
            id = item.id,
            name = item.name,
            image = item.ownerDto.image,
            author = item.ownerDto.author,
            stargazersCount = item.stargazersCount,
            forksCount = item.forksCount
        )
    }
}
