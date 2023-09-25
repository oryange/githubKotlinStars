package com.example.app.view.repositoryDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.app.model.RepositoryItem
import com.example.app.repository.dataLocal.RepositoryItemCache

class RepositoryDetailViewModel(private val context: Context) : ViewModel() {

    fun getItemRepository(itemId: String): RepositoryItem? =
        RepositoryItemCache(context).getRepositoryItemById(itemId)
}
