package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.theme.AppTheme
import com.example.app.view.RepositoryDetail
import com.example.app.view.RepositoryList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "repositoryList") {
                    composable(route = "repositoryList") {
                        RepositoryList(navController = navController)
                    }
                    composable(route = "repositoryDetail") {
                        RepositoryDetail(navController = navController)
                    }
                }
            }
        }
    }
}
