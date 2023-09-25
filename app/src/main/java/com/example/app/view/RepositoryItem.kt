package com.example.app.view

import android.graphics.Color.BLACK
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.app.model.RepositoryItem

@Composable
fun RepositoryItem(position: Int, list: MutableList<RepositoryItem>) {
    val itemTitle = list[position].name
    val itemImage = list[position].image
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                //navController.navigate("repositoryDetail")
            }) {
        ConstraintLayout(Modifier.padding(16.dp)) {
            val (title, image) = createRefs()
            Text(
                text = itemTitle,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                }
            )
            AsyncImage(
                model = itemImage,
                contentDescription = "repository $itemTitle image",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(title.bottom, margin = 8.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
                    .size(100.dp, 100.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = Color.Gray)
            )
        }

    }
}
