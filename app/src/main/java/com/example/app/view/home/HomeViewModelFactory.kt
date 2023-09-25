package com.example.app.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.repository.dataRemote.GithubRepository

class HomeViewModelFactory(private val githubRepository: GithubRepository) : ViewModelProvider.Factory {
    override fun<T: ViewModel>create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(HomeViewModel::class.java)){
            return HomeViewModel(githubRepository) as T
        }
        throw IllegalArgumentException("Unknown HomeViewModel class")
    }
}
