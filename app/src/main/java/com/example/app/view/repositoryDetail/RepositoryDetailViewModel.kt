package com.example.app.view.repositoryDetail

import androidx.lifecycle.ViewModel
import com.example.app.model.RepositoryItem
import com.example.app.repository.dataLocal.RepositoryItemLocalCache

internal class RepositoryDetailViewModel(
    private val repositoryItemLocalCache: RepositoryItemLocalCache
) : ViewModel() {

    fun getItemRepository(itemId: String): RepositoryItem? =
        repositoryItemLocalCache.getRepositoryItemById(itemId)
}
