package com.example.login.form.ui.screens

import com.example.login.form.ui.list.CharacterList
import SearchView
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.navigation.NavHostController
import com.example.viewmodels.MainViewModel

@Composable
fun SearchScreen(navHostController: NavHostController, viewModel: MainViewModel) {
    val focusManager = LocalFocusManager.current
    val textState = remember { mutableStateOf("") }
    Column {
        SearchView(textState)
        CharacterList(
            navController = navHostController,
            characters = viewModel.filterCharacterList(textState.value)
        )
    }
}
