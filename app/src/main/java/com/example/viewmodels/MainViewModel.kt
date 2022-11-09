package com.example.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.toLowerCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.form.api.RetrofitHelper
import com.example.login.form.data.Character
import kotlinx.coroutines.launch
import java.util.Objects

class MainViewModel:ViewModel() {
    var characterList:List<Character> by mutableStateOf(arrayListOf())

    var errorMessage: String by mutableStateOf("")

    var loading: Boolean by mutableStateOf(true)

    fun requestCharacterList(){
        viewModelScope.launch {
            loading = true
            val authService = RetrofitHelper.getAuthService()

            try {
                val response = authService.getCharacters()
                characterList = response
                loading = false
                errorMessage = ""
            }
            catch (e: Exception) {
                loading = false
                errorMessage = e.message.toString()
            }
        }
    }

    fun filterCharacterList(characterName: String): List<Character> {
        if (characterName == "") return arrayListOf()

        return characterList.filter {
                character -> character.name.lowercase().contains(characterName.lowercase())
        }
    }
}
