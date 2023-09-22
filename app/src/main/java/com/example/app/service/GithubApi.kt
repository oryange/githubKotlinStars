package com.example.app.service

import com.example.app.service.response.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface GithubApi {
    @GET("search/repositories?q=language:kotlin&sort=stars&page=1")
    suspend fun getRepositories(): Response<RepositoryResponse>
}
