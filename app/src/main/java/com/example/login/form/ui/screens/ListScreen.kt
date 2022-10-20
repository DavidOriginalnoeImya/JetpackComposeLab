package com.example.login.form.ui.screens

import android.util.Log
import android.widget.RatingBar
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.login.form.ui.NavRoutes
import com.example.viewmodels.MainViewModel
import coil.compose.AsyncImage
import com.example.login.form.R
import com.gowtham.ratingbar.RatingBar
import java.io.InputStream
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun ListScreen(navController: NavHostController,  viewModel: MainViewModel) {
    val context = LocalContext.current

    LaunchedEffect(context) {
        var json: String = ""
        val inputStream: InputStream = context.assets.open("all.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        json = String(buffer, charset("UTF-8"))
        viewModel.parseCharactersList(json)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(viewModel.characterList.size.toString())
        CharactersList(navController, characters = viewModel.characterList)
    }
}

@Composable
fun CharactersList(navController: NavHostController, characters: ArrayList<com.example.data.Character>) {
    LazyVerticalGrid (columns = GridCells.Adaptive(160.dp)){
        items(characters.size) { index ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clickable (
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

                    Row (modifier = Modifier.padding(start = 12.dp, bottom = 5.dp)) {
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

