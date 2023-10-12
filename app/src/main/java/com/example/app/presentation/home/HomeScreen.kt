package com.example.app.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.app.R
import com.example.app.presentation.home.component.RepositoryItemComponent
import com.example.app.presentation.home.viewmodel.HomeUiState
import com.example.app.presentation.ui.theme.Purple700
import com.example.app.presentation.ui.theme.White

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun HomeScreen(
    state: HomeUiState,
    onItemClick: (id: Int) -> Unit
) {
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
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = state,
            onItemClick = onItemClick
        )
    }
}

@ExperimentalMaterialApi
@Composable
private fun HomeScreenContent(
    modifier: Modifier,
    state: HomeUiState,
    onItemClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is HomeUiState.Error -> Text(text = state.message)
            is HomeUiState.Loading -> CircularProgressIndicator()
            is HomeUiState.Success -> LazyColumn {
                items(state.repositories) { item ->
                    RepositoryItemComponent(
                        item = item,
                        onClick = onItemClick
                    )
                }
            }
        }
    }
}
