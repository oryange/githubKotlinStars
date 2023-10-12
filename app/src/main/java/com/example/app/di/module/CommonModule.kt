package com.example.app.di.module

import android.content.Context
import android.content.SharedPreferences
import com.example.app.data.local.LocalItemDataSource
import com.google.gson.Gson

internal class CommonModule(
    private val context: Context
) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    val localItemDataSource by lazy {
        LocalItemDataSource(
            sharedPreferences = sharedPreferences,
            gson = Gson()
        )
    }

    companion object {
        private const val PREFS_NAME = "repository_item_cache"
    }
}
