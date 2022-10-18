package com.example.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    var characterList:ArrayList<com.example.data.Character> by mutableStateOf(arrayListOf())

    fun parseCharactersList(jsonString:String){
        viewModelScope.launch {
            val myType = object : TypeToken<ArrayList<com.example.data.Character>>() {}.type
            val list: ArrayList<com.example.data.Character> = Gson().fromJson(jsonString, myType)
            characterList = list;
        }
    }
}
