package com.example.app

import android.app.Application
import com.example.app.util.InjectionsContainer

class MainApplication : Application() {
    override fun onCreate() {
        InjectionsContainer(this)
        super.onCreate()
    }
}
