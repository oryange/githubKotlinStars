package com.example.app.domain.repository

import com.example.app.domain.model.RepositoryItem

internal interface ItemRepository {

    suspend fun saveRepositoryItems(items: List<RepositoryItem>)
    suspend fun getRepositoryItems(): List<RepositoryItem>?
    suspend fun getRepositoryItemById(itemId: Int): RepositoryItem?
}
