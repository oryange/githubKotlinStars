package com.example.app.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.R

@Composable
fun RepositoryItem(text: String, imageResId: Int) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                //navController.navigate("repositoryDetail")
            }) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = text,
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "repository image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(MaterialTheme.shapes.medium)
            )
        }
    }
}

@Composable
@Preview
private fun RepositoryItemPreview() {
    RepositoryItem("Repository Kotlin", R.drawable.image_test)
}
