package com.example.app.view.repositoryDetail

import android.content.Context
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.app.view.repositoryDetail.RepositoryDetailViewModel
import com.example.app.view.repositoryDetail.RepositoryDetailViewModelFactory

@Composable
internal fun RepositoryDetail(
    repositoryDetailViewModelFactory: RepositoryDetailViewModelFactory,
    id: String
) {
    val viewModel: RepositoryDetailViewModel = viewModel(factory = repositoryDetailViewModelFactory)

    val item = viewModel.getItemRepository(id)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = item?.image,
                contentDescription = "repository $item?.image image",
                modifier = Modifier
                    .size(100.dp, 100.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = Color.Gray)
            )
            Text(
                text = "Author: ${item?.author}",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Stargazers: ${item?.stargazersCount}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Text(
                text = "Forks: ${item?.forksCount}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                ),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}
