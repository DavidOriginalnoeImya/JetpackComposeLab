package com.example.login.form.ui.screens

import com.example.login.form.ui.list.CharacterList
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.form.ui.NavRoutes
import com.example.viewmodels.MainViewModel

@Composable
fun ListScreen(navController: NavHostController,  viewModel: MainViewModel) {
    val context = LocalContext.current

    LaunchedEffect(context) {
        viewModel.requestCharacterList()
    }

    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {Text("")},
                backgroundColor = MaterialTheme.colors.primary,
                actions = {
                    IconButton(
                        onClick = { navController.navigate(NavRoutes.Search.route) },
                    ) {
                        Icon(Icons.Filled.Search, contentDescription = "")
                    }
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (viewModel.loading) {
                    CircularProgressIndicator()
                } else if (viewModel.errorMessage !== "") {
                    Text(
                        modifier = Modifier.padding(all = 8.dp),
                        textAlign = TextAlign.Center,
                        text = viewModel.errorMessage,
                        style = MaterialTheme.typography.h6,
                        color = Color.Red
                    )
                }
                else CharacterList(navController, characters = viewModel.characterList)
            }
        },
    )
}

