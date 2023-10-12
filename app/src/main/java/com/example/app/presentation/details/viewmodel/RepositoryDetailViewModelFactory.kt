package com.example.app.presentation.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.module.DetailsModule

internal class RepositoryDetailViewModelFactory(
    private val detailsModule: DetailsModule,
    private val id: String,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        if (modelClass.isAssignableFrom(RepositoryDetailViewModel::class.java)) {
            RepositoryDetailViewModel(
                itemRepository = detailsModule.itemRepository,
                itemId = id
            ) as T
        } else {
            throw IllegalArgumentException("Unknown RepositoryDetailViewModel class")
        }
}
