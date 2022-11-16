package com.example.login.form.db.converter

import androidx.room.TypeConverter
import com.example.login.form.data.Work

import com.google.gson.Gson

class WorkConverter {
    @TypeConverter
    fun fromImage(work: Work?): String {
        return Gson().toJson(work);
    }
    @TypeConverter
    fun toImage(data: String): Work? {
        return Gson().fromJson(data, Work::class.java)
    }
}
