package com.example.app.presentation.details

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.domain.model.RepositoryItem
import com.example.app.presentation.details.viewmodel.RepositoryDetailUiState
import com.example.app.presentation.ui.component.AppBar
import com.example.app.presentation.ui.component.RepoImageComponent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
internal fun RepositoryDetailsScreen(
    state: RepositoryDetailUiState,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AppBar(
                title = state.appBarTitle,
                onBack = onBack
            )
        }
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it),
            elevation = 8.dp
        ) {
            when (state) {
                is RepositoryDetailUiState.Error -> Text(text = state.message)
                is RepositoryDetailUiState.Loading -> CircularProgressIndicator()
                is RepositoryDetailUiState.Success -> SuccessStateComponent(item = state.item)
            }
        }
    }
}

@Composable
private fun SuccessStateComponent(item: RepositoryItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        RepoImageComponent(
            image = item.image,
            name = item.name,
        )
        Text(
            text = "Author: ${item.author}",
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Stargazers: ${item.stargazersCount}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "Forks: ${item.forksCount}",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
