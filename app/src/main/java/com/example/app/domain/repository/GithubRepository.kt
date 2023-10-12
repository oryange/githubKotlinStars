package com.example.app.domain.repository

import com.example.app.domain.model.RepositoryItem

internal interface GithubRepository {
    suspend fun getRepositories(): Result<List<RepositoryItem>>
}
