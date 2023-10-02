package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.ui.theme.AppTheme
import com.example.app.util.InjectionsContainer
import com.example.app.util.StringUtils
import com.example.app.view.home.RepositoryList
import com.example.app.view.repositoryDetail.RepositoryDetail

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "repositoryList") {
                    composable(route = "repositoryList") {
                        RepositoryList(
                            navController = navController,
                            homeViewModelFactory = InjectionsContainer(LocalContext.current).homeViewModelFactory
                        )
                    }
                    composable(route = "repositoryDetail/{id}") { entry ->
                        RepositoryDetail(
                            InjectionsContainer(context = LocalContext.current).repositoryDetailViewModelFactory,
                            id = entry.arguments?.getString("id") ?: StringUtils.EMPTY
                        )
                    }
                }
            }
        }
    }
}



