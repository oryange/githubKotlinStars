package com.example.app.di

import android.content.Context
import com.example.app.di.module.CommonModule
import com.example.app.di.module.DetailsModule
import com.example.app.di.module.HomeModule

internal class Di(private val context: Context) {

    val detailsModule by lazy {
        DetailsModule(commonModule.localItemDataSource)
    }

    val homeModule by lazy {
        HomeModule(commonModule.localItemDataSource)
    }

    private val commonModule by lazy {
        CommonModule(context)
    }
}
