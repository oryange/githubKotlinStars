package com.example.app.repository.dataLocal

import com.example.app.model.RepositoryItem

internal interface RepositoryItemLocalCache {

    fun saveRepositoryItems(items: MutableList<RepositoryItem>)
    fun getRepositoryItems(): MutableList<RepositoryItem>?
    fun getRepositoryItemById(itemId: String): RepositoryItem?
}
