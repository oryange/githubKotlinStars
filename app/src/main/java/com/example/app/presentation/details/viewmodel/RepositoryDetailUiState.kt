package com.example.app.presentation.details.viewmodel

import com.example.app.domain.model.RepositoryItem

internal sealed class RepositoryDetailUiState(open val appBarTitle: String) {

    data class Success(val item: RepositoryItem): RepositoryDetailUiState(item.name)

    data class Error(val message: String): RepositoryDetailUiState(DEFAULT_APP_BAR_TITLE)

    object Loading: RepositoryDetailUiState(DEFAULT_APP_BAR_TITLE)

    companion object {
        private const val DEFAULT_APP_BAR_TITLE = "Repository details"
    }
}
