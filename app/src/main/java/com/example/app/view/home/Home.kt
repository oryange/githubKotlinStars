package com.example.app.view.home

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.app.R
import com.example.app.model.RepositoryItem
import com.example.app.ui.theme.Purple700
import com.example.app.ui.theme.White
import com.example.app.view.RepositoryItem


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun RepositoryList(
    navController: NavController,
    homeViewModelFactory: HomeViewModelFactory,
) {
    val homeViewModel: HomeViewModel = viewModel(factory = homeViewModelFactory)

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple700,
                title = {
                    Text(
                        text = stringResource(R.string.top_bar_name),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        }
    ) {
        val list: MutableList<RepositoryItem> =
            homeViewModel.getRepositories().collectAsState(mutableListOf()).value
        LazyColumn {
            itemsIndexed(list) { position, _ ->
                RepositoryItem(position, list, navController)
            }
        }
    }
}
