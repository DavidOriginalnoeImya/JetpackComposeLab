package com.example.login.form.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.login.form.ui.NavRoutes
import com.example.viewmodels.MainViewModel
import coil.compose.AsyncImage
import com.example.login.form.R
import com.example.login.form.data.Character
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig

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
                        onClick = { /*TODO*/ },
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
                else CharactersList(navController, characters = viewModel.characterList)
            }
        },
    )
}

@Composable
fun CharactersList(navController: NavHostController, characters: List<Character>) {
    LazyVerticalGrid (columns = GridCells.Adaptive(160.dp)){
        items(characters.size) { index ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clickable(
                        onClick = {
                            navController.navigate(NavRoutes.Detail.route + "/" + index)
                        }
                    )
            ) {
                Column{
                    AsyncImage(
                        model = characters[index].images.lg,
                        contentDescription = null
                    )

                    Text(
                        modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 5.dp),
                        text = characters[index].name
                    )

                    Row (modifier = Modifier.padding(start = 7.dp, bottom = 10.dp, top = 5.dp)) {
                        Icon(
                            painter = painterResource(R.drawable.ic_baseline_sports_mma_24),
                            contentDescription = null
                        )

                        RatingBar(
                            value = characters[index].powerstats.power.toFloat() / 20,
                            config = RatingBarConfig()
                                .size(15.dp)
                                .numStars(5),
                            onValueChange = {},
                            onRatingChanged = {}
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun ToolBar(content: () -> Unit) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopAppBar(title = {Text("Top App Bar")},backgroundColor = MaterialTheme.colors.primary)  },
        content = { content },
    )
}

