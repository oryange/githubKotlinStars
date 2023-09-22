package com.example.app.repository.dataRemote

import com.example.app.service.response.RepositoryResponse
import com.example.app.util.ResultState

internal interface GithubRepository {

    suspend fun getRepositories(): ResultState<RepositoryResponse>
}
