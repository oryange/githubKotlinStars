package com.example.app.view.repositoryDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RepositoryDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RepositoryDetailViewModel::class.java)) {
            return RepositoryDetailViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown RepositoryDetailViewModel class")
    }
}
