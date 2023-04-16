package com.example.smartlight.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LightEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun lightDao(): LightDao

    companion object{
        val DATABASE_NAME = "smart_light_db"
    }
}