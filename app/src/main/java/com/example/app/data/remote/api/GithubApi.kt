package com.example.app.data.remote.api

import com.example.app.data.dto.RepositoryDto
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {
    @GET("search/repositories?q=language:kotlin&sort=stars&page=1")
    suspend fun getRepositories(): Response<RepositoryDto>
}
