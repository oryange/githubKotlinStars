package com.example.app.presentation.home.viewmodel

import com.example.app.domain.model.RepositoryItem

internal sealed interface HomeUiState {
    object Loading: HomeUiState
    data class Error(val message: String): HomeUiState
    data class Success(val repositories: List<RepositoryItem>): HomeUiState
}
