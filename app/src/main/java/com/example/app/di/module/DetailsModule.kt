package com.example.app.di.module

import com.example.app.data.local.ItemRepositoryImpl
import com.example.app.data.local.LocalItemDataSource

internal class DetailsModule(
    private val localItemDataSource: LocalItemDataSource
) {
    val itemRepository by lazy {
        ItemRepositoryImpl(localItemDataSource)
    }
}
