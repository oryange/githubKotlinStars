package com.example.app.view

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app.R
import com.example.app.model.Repository
import com.example.app.ui.theme.Purple700
import com.example.app.ui.theme.White

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RepositoryList(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Purple700,
                title = {
                    Text(
                        text = "Github Kotlin Stars",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = White
                    )
                }
            )
        }
    ) {
        val list: MutableList<Repository> = mutableListOf(
        Repository("Kotlin", R.drawable.image_test),
        Repository("Kotlin for beginners", R.drawable.image_test),
        Repository("Kotlin from zero to advanced", R.drawable.image_test),
        )
        LazyColumn {
            itemsIndexed(list) { position, _ ->
                RepositoryItem(position, list)
            }
        }
    }
}
