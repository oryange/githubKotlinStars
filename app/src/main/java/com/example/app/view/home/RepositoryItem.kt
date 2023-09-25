package com.example.app.view

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.app.model.RepositoryItem


@Composable
fun RepositoryItem(position: Int, list: MutableList<RepositoryItem>, navController: NavController) {
    val itemId = list[position].id
    val itemTitle = list[position].name
    val itemImage = list[position].image
    Card(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navController.navigate("repositoryDetail/$itemId")
            }) {
        ConstraintLayout(Modifier.padding(16.dp)) {
            val (title, image) = createRefs()
            AsyncImage(
                model = itemImage,
                contentDescription = "repository $itemTitle image",
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top, margin = 8.dp)
                        start.linkTo(parent.start, margin = 8.dp)
                    }
                    .size(100.dp, 100.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = Color.Gray)
            )
            Text(
                text = itemTitle,
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black
                ),
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(image.bottom, margin = 8.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                }
            )
        }

    }
}
