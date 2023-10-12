package com.example.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app.di.module.DetailsModule
import com.example.app.di.module.HomeModule
import com.example.app.presentation.details.RepositoryDetailsScreen
import com.example.app.presentation.details.viewmodel.RepositoryDetailUiState
import com.example.app.presentation.details.viewmodel.RepositoryDetailViewModel
import com.example.app.presentation.details.viewmodel.RepositoryDetailViewModelFactory
import com.example.app.presentation.home.HomeScreen
import com.example.app.presentation.home.viewmodel.HomeUiState
import com.example.app.presentation.home.viewmodel.HomeViewModel
import com.example.app.presentation.home.viewmodel.HomeViewModelFactory
import com.example.app.presentation.ui.theme.AppTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModel.getFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val di = viewModel.di
        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "repositoryList") {
                    composable(route = "repositoryList") {
                        HomeScreenComposable(
                            homeModule = di.homeModule,
                            navController = navController
                        )
                    }
                    composable(route = "repositoryDetail/{id}") { entry ->
                        RepositoryDetailComposable(
                            navController = navController,
                            detailsModule = di.detailsModule,
                            id = entry.arguments?.getString("id").orEmpty()
                        )
                    }
                }
            }
        }
    }

    @Composable
    private fun HomeScreenComposable(
        homeModule: HomeModule,
        navController: NavHostController
    ) {
        val homeViewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(homeModule))
        val state: HomeUiState by homeViewModel.repositories.collectAsState()
        HomeScreen(
            state = state,
            onItemClick = { id ->
                navController.navigate("repositoryDetail/$id")
            },
        )
    }

    @Composable
    private fun RepositoryDetailComposable(
        navController: NavHostController,
        detailsModule: DetailsModule,
        id: String
    ) {
        val repositoryDetailViewModel: RepositoryDetailViewModel = viewModel(
            factory = RepositoryDetailViewModelFactory(
                detailsModule = detailsModule,
                id = id
            ),
            key = id
        )
        val state: RepositoryDetailUiState by repositoryDetailViewModel.state.collectAsState()
        RepositoryDetailsScreen(
            state = state,
            onBack = navController::popBackStack
        )
    }
}



