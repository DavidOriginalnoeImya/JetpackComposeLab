package com.example.login.form.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.viewmodels.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage

@Composable
fun DetailScreen(navController: NavHostController, id:String?,  viewModel: MainViewModel) {

    val configuration = LocalConfiguration.current

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        if (id != null) {
            AsyncImage(
                model = viewModel.characterList[id.toInt()].images.lg,
                contentDescription = null,
                modifier = Modifier.width(configuration.screenWidthDp.dp)
            )
        }
    }
}
