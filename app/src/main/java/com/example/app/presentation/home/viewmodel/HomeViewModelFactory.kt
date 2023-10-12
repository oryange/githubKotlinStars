package com.example.app.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.module.HomeModule

internal class HomeViewModelFactory(
    private val homeModule: HomeModule,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(homeModule.githubRepository) as T
        }
        throw IllegalArgumentException("Unknown HomeViewModel class")
    }
}
