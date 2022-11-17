package com.example.login.form.ui.screens

import PowerStatsList
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.viewmodels.MainViewModel
import coil.compose.AsyncImage
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInParent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import java.util.logging.Logger
import kotlin.math.roundToInt

@OptIn(
    ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class,
)
@Composable
fun DetailScreen(
    navController: NavHostController,
    id:String?,
    viewModel: MainViewModel,
) {
    val configuration = LocalConfiguration.current

    val coroutineScope = rememberCoroutineScope()
    val scrollableState = rememberScrollState()
    var scrollToPosition  by remember { mutableStateOf(0F) }

    val context = LocalContext.current

//    LaunchedEffect(context) {
//        viewModel.requestCharacterList()
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollableState)
    ) {
        if (id != null) {
            val characterId = id.toInt()

            AsyncImage(
                model = viewModel.characterList[characterId].images.lg,
                contentDescription = null,
                modifier = Modifier.width(configuration.screenWidthDp.dp + 3.dp),
                contentScale = ContentScale.FillWidth
            )

            Column(modifier = Modifier.padding(start = 15.dp, top = 15.dp)) {
                Text(
                    text = viewModel.characterList[characterId].name,
                    fontSize = 30.sp,
                )

                var realName = viewModel.characterList[characterId].biography.fullName

                if (realName == "") realName = viewModel.characterList[characterId].name

                Text(
                    text = "Real name: $realName",
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(15.dp))

                PowerStatsList(characterId, viewModel, onClick = {
                    coroutineScope.launch {
                        scrollableState.animateScrollTo(scrollToPosition.roundToInt())
                    }
                })

                Spacer(modifier = Modifier.height(15.dp))

                Text(
                    text = viewModel.characterList[characterId].work.occupation,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.onGloballyPositioned { coordinates ->
                        scrollToPosition = coordinates.positionInParent().y
                    }
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}



