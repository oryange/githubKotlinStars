package com.example.app.di.module

import com.example.app.data.local.LocalItemDataSource
import com.example.app.data.mapper.RepositoryItemMapper
import com.example.app.data.remote.api.RetrofitConfig
import com.example.app.data.remote.datasource.RemoteGithubDataSource
import com.example.app.data.remote.repository.GithubRepositoryImpl
import com.example.app.domain.repository.GithubRepository

internal class HomeModule(private val localItemDataSource: LocalItemDataSource) {

    val githubRepository: GithubRepository by lazy {
        GithubRepositoryImpl(
            remoteDataSource = remoteGithubDataSource,
            localDataSource = localItemDataSource,
            mapper = RepositoryItemMapper()
        )
    }

    private val remoteGithubDataSource: RemoteGithubDataSource by lazy {
        RemoteGithubDataSource(RetrofitConfig.getApiService())
    }
}
