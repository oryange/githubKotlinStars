package com.example.app.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.domain.model.RepositoryItem
import com.example.app.presentation.ui.component.RepoImageComponent

@ExperimentalMaterialApi
@Composable
internal fun RepositoryItemComponent(
    item: RepositoryItem,
    onClick: (id: Int) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = { onClick(item.id) }
    ) {
        Column(Modifier.padding(16.dp)) {
            RepoImageComponent(
                image = item.image,
                name = item.name,
            )
            Text(
                text = "Repository: ${item.name}",
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black
                ),
            )
        }
    }
}
