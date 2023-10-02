package com.example.app.util

import android.content.Context
import com.example.app.repository.dataLocal.RepositoryItemLocalCacheImpl
import com.example.app.repository.dataRemote.GithubRepositoryImpl
import com.example.app.service.RetrofitConfig
import com.example.app.view.home.HomeViewModelFactory
import com.example.app.view.repositoryDetail.RepositoryDetailViewModelFactory

internal class InjectionsContainer(context: Context) {

    //TODO(): verify how to use this:
//    private lateinit var context: Context
//
//    fun initialize(context: Context) {
//        this.context = context
//    }

    private val repositoryItemLocalCacheImpl = RepositoryItemLocalCacheImpl(context)
    val homeViewModelFactory: HomeViewModelFactory = HomeViewModelFactory(
        githubRepository = GithubRepositoryImpl(RetrofitConfig.getApiService()),
        repositoryItemLocalCache = repositoryItemLocalCacheImpl
    )

    val repositoryDetailViewModelFactory: RepositoryDetailViewModelFactory =
        RepositoryDetailViewModelFactory(repositoryItemLocalCacheImpl)
}
