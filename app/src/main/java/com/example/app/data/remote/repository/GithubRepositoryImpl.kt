package com.example.app.data.remote.repository

import com.example.app.data.local.LocalItemDataSource
import com.example.app.data.mapper.RepositoryItemMapper
import com.example.app.data.remote.datasource.RemoteGithubDataSource
import com.example.app.domain.repository.GithubRepository
import com.example.app.domain.model.RepositoryItem

internal class GithubRepositoryImpl(
    private val remoteDataSource: RemoteGithubDataSource,
    private val localDataSource: LocalItemDataSource,
    private val mapper: RepositoryItemMapper,
) : GithubRepository {

    override suspend fun getRepositories(): Result<List<RepositoryItem>> = Result.runCatching {
        localDataSource.getItems() ?: getFromRemote()
    }

    private suspend fun getFromRemote(): List<RepositoryItem> = mapper.map(
        dto = remoteDataSource.getRepositories().getOrThrow()
    ).also { items ->
        localDataSource.saveItems(items)
    }
}
