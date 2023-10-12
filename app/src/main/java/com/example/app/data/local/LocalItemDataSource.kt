package com.example.app.data.local

import android.content.SharedPreferences
import com.example.app.domain.model.RepositoryItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class LocalItemDataSource(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson,
) {

    suspend fun saveItems(items: List<RepositoryItem>) = withContext(Dispatchers.IO) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val itemsJson = gson.toJson(items)
        editor.putString(KEY_REPOSITORY_ITEMS, itemsJson)
        editor.apply()
    }

    suspend fun getItems(): List<RepositoryItem>? = withContext(Dispatchers.IO) {
        val itemsJson = sharedPreferences.getString(KEY_REPOSITORY_ITEMS, null)
        gson.fromJson(itemsJson, Array<RepositoryItem>::class.java)?.toList()
    }

    companion object {
        private const val KEY_REPOSITORY_ITEMS = "repository_items"
    }
}
