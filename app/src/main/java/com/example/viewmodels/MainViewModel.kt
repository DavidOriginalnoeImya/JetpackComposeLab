package com.example.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.form.api.RetrofitHelper
import com.example.login.form.data.Character
import kotlinx.coroutines.launch

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
}
