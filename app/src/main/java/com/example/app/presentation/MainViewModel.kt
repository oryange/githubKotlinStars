package com.example.app.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.Di

internal class MainViewModel(
    val di: Di,
) : ViewModel() {

    companion object {
        fun getFactory(context: Context): ViewModelProvider.Factory =
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T =
                    if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                        MainViewModel(
                            di = Di(context)
                        ) as T
                    } else {
                        throw IllegalArgumentException("Unknown MainViewModel class")
                    }
            }
    }
}
