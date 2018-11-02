package com.example.parsiphal.shakefidgethelper.date


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [DungeonTable::class], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun getDao(): Dao
}