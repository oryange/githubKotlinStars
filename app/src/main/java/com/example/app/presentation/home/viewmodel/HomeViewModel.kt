package com.example.app.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.repository.GithubRepository
import com.example.app.domain.model.RepositoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class HomeViewModel(
    private val githubRepository: GithubRepository,
) : ViewModel() {

    private val _repositories = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val repositories: StateFlow<HomeUiState> = _repositories

    init {
        viewModelScope.launch {
            updateUiState(githubRepository.getRepositories())
        }
    }

    private fun updateUiState(result: Result<List<RepositoryItem>>) {
        _repositories.update {
            result.getOrNull()?.let { items ->
                HomeUiState.Success(items)
            } ?: HomeUiState.Error(
                result.exceptionOrNull()?.message ?: UNKNOWN_ERROR_MESSAGE
            )
        }
    }

    companion object {
        private const val UNKNOWN_ERROR_MESSAGE = "Unknown error"
    }
}
