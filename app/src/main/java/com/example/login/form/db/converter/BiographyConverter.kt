package com.example.login.form.db.converter

import androidx.room.TypeConverter
import com.example.login.form.data.Biography

import com.google.gson.Gson

class BiographyConverter {
    @TypeConverter
    fun fromImage(biography: Biography?): String {
        return Gson().toJson(biography);
    }
    @TypeConverter
    fun toImage(data: String): Biography? {
        return Gson().fromJson(data,Biography::class.java)
    }
}
