package com.example.app.repository.dataLocal

import android.content.Context
import android.content.SharedPreferences
import com.example.app.model.RepositoryItem
import com.example.app.util.StringUtils.KEY_REPOSITORY_ITEMS
import com.example.app.util.StringUtils.PREFS_NAME
import com.google.gson.Gson

class RepositoryItemCache(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveRepositoryItems(items: MutableList<RepositoryItem>) {
        val editor: SharedPreferences.Editor = prefs.edit()
        val itemsJson = gson.toJson(items)
        editor.putString(KEY_REPOSITORY_ITEMS, itemsJson)
        editor.apply()
    }

    fun getRepositoryItems(): MutableList<RepositoryItem>? {
        val itemsJson = prefs.getString(KEY_REPOSITORY_ITEMS, null)
        return gson.fromJson(itemsJson, Array<RepositoryItem>::class.java)?.toMutableList()
    }

    fun getRepositoryItemById(itemId: String): RepositoryItem? {
        val itemsJson = prefs.getString(KEY_REPOSITORY_ITEMS, null)
        val items = gson.fromJson(itemsJson, Array<RepositoryItem>::class.java)
        return items?.firstOrNull { it.id == itemId.toInt() }
    }
}
