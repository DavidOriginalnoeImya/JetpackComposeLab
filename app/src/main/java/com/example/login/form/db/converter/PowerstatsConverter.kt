package com.example.login.form.db.converter

import androidx.room.TypeConverter
import com.example.login.form.data.Powerstats

import com.google.gson.Gson

class PowerstatsConverter {
    @TypeConverter
    fun fromImage(powerstats: Powerstats?): String {
        return Gson().toJson(powerstats);
    }
    @TypeConverter
    fun toImage(data: String): Powerstats? {
        return Gson().fromJson(data,Powerstats::class.java)
    }
}
