package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.repository.dataRemote.GithubRepositoryImpl
import com.example.app.service.RetrofitConfig
import com.example.app.ui.theme.AppTheme
import com.example.app.util.ResultState
import com.example.app.util.StringUtils
import com.example.app.view.RepositoryDetail
import com.example.app.view.RepositoryList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "repositoryList") {
                    composable(route = "repositoryList") {
                        RepositoryList(navController = navController, LocalContext.current)
                    }
                    composable(route = "repositoryDetail/{id}") { entry->
                        RepositoryDetail(
                            context =  LocalContext.current,
                            id = entry.arguments?.getString("id") ?: StringUtils.EMPTY
                        )
                    }
                }
            }
        }
    }
}



