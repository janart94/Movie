package com.example.movies.room.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.movies.models.Genres

open class GenresListConverter {
    @TypeConverter
    fun fromString(value: String): List<Genres>? {
        val listType = object : TypeToken<List<Genres>>() {}.type
        return Gson().fromJson<List<Genres>>(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Genres>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}
