package com.example.app.repository.dataRemote

import com.example.app.service.GithubApi
import com.example.app.service.response.RepositoryResponse
import com.example.app.util.ResultState

class GithubRepositoryImpl(private val githubApi: GithubApi) : GithubRepository {
    override suspend fun getRepositories(): ResultState<RepositoryResponse> {
        return try {
            val response = githubApi.getRepositories()
            if (response.isSuccessful) {
                response.body()?.let {
                    ResultState.Success(it)
                } ?: ResultState.Error("Response body is null")
            } else {
                ResultState.Error("Unsuccessful response from API")
            }
        } catch (e: Exception) {
            ResultState.Error("Error calling API: $e")
        }
    }
}
