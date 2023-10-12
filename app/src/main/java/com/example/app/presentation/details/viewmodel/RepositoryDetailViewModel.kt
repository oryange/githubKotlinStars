package com.example.app.presentation.details.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.repository.ItemRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class RepositoryDetailViewModel(
    private val itemRepository: ItemRepository,
    private val itemId: String,
) : ViewModel() {

    private val _state: MutableStateFlow<RepositoryDetailUiState> =
        MutableStateFlow(RepositoryDetailUiState.Loading)

    val state: StateFlow<RepositoryDetailUiState> = _state

    init {
        viewModelScope.launch {
            _state.update {
                itemRepository.getRepositoryItemById(itemId.toInt())?.let { item ->
                    RepositoryDetailUiState.Success(item)
                } ?: RepositoryDetailUiState.Error("There's no item with id $itemId")
            }
        }
    }
}
