package com.example.app.data.local

import com.example.app.domain.repository.ItemRepository
import com.example.app.domain.model.RepositoryItem

internal class ItemRepositoryImpl(
    private val dataSource: LocalItemDataSource,
) : ItemRepository {

    override suspend fun saveRepositoryItems(items: List<RepositoryItem>) {
        dataSource.saveItems(items)
    }

    override suspend fun getRepositoryItems(): List<RepositoryItem>? = dataSource.getItems()

    override suspend fun getRepositoryItemById(itemId: Int): RepositoryItem? =
        dataSource.getItems()?.firstOrNull { item ->
            item.id == itemId
        }
}
