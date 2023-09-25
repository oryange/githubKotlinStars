package com.example.app.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.model.RepositoryItem
import com.example.app.repository.dataRemote.GithubRepository
import com.example.app.util.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val githubRepository: GithubRepository) : ViewModel() {

    private val _repositories = MutableStateFlow<MutableList<RepositoryItem>>(mutableListOf())
    private val repositories: StateFlow<MutableList<RepositoryItem>> = _repositories

    // TODO() remove this
    // TODO() implement cash strategy
    private val defaultValue = mutableListOf(
        RepositoryItem(
            id = 16,
            name = "kotlin",
            image = "https://avatars.githubusercontent.com/u/878437?v=4",
            author = "afollestad",
            stargazersCount = 45850,
            forksCount = 1765
        )
    )

    fun getRepositories(): Flow<MutableList<RepositoryItem>> {
        val repositorieList: MutableList<RepositoryItem> = mutableListOf()
        viewModelScope.launch {
            val response = githubRepository.getRepositories()
            response.let {
                when (it) {
                    is ResultState.Success -> {
                        it.data.items.map { item ->
                            repositorieList.add(
                                RepositoryItem(
                                    id = item.id,
                                    name = item.name,
                                    image = item.owner.image,
                                    author = item.owner.author,
                                    stargazersCount = item.stargazersCount,
                                    forksCount = item.forksCount
                                )
                            )
                        }
                        _repositories.value = repositorieList
                    }
                    is ResultState.Error -> _repositories.value = defaultValue
                }
            }
        }
        return repositories
    }


}
