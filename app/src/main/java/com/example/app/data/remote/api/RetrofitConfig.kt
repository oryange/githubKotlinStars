package com.example.app.data.remote.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitConfig {
    private const val BASE_URL = "https://api.github.com/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient())
        .build()

    fun getApiService(): GithubApi = retrofit.create(GithubApi::class.java)
}
