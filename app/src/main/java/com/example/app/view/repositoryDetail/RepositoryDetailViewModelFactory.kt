package com.example.app.view.repositoryDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.repository.dataLocal.RepositoryItemLocalCache

internal class RepositoryDetailViewModelFactory(private val repositoryItemLocalCache: RepositoryItemLocalCache) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryDetailViewModel::class.java)) {
            return RepositoryDetailViewModel(repositoryItemLocalCache) as T
        }
        throw IllegalArgumentException("Unknown RepositoryDetailViewModel class")
    }
}
