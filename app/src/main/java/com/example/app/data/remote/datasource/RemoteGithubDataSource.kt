package com.example.app.data.remote.datasource

import com.example.app.data.dto.RepositoryDto
import com.example.app.data.remote.api.GithubApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteGithubDataSource(private val api: GithubApi) {

    suspend fun getRepositories(): Result<RepositoryDto> = Result.runCatching {
        withContext(Dispatchers.IO) {
            api.getRepositories().run {
                if (isSuccessful) {
                    body() ?: throw Exception("Response body is null")
                } else {
                    throw Exception("Unsuccessful response from API")
                }
            }
        }
    }
}
