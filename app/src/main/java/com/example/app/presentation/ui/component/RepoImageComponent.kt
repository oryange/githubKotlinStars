package com.example.app.presentation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage

@Composable
fun RepoImageComponent(
    image: String,
    name: String,
    modifier: Modifier = Modifier,
) {
    SubcomposeAsyncImage(
        modifier = modifier
            .size(100.dp, 100.dp)
            .clip(CircleShape)
            .border(
                width = 2.dp,
                color = Color.Gray
            ),
        model = image,
        contentDescription = "Repository $name image",
        loading = {
            CircularProgressIndicator()
        }
    )
}
