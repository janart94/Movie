package com.example.movies.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movies.models.entity.Movie
import com.example.movies.room.converters.GenresListConverter
import com.example.movies.room.converters.IntegerListConverter
import com.example.movies.room.converters.StringListConverter

@Database(entities = [(Movie::class)],
        version = 3, exportSchema = false)
@TypeConverters(value = [(StringListConverter::class), (IntegerListConverter::class), (GenresListConverter::class)])
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
