package com.example.parsiphal.shakefidgethelper

import android.app.Application
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import com.example.parsiphal.shakefidgethelper.date.DataBase

const val DB_NAME = "helper_DB"

val DB: DataBase by lazy {
    MainApp.mDataBase!!
}

class MainApp : Application() {

    companion object {
        var mDataBase: DataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        mDataBase = Room
            .databaseBuilder(applicationContext, DataBase::class.java, DB_NAME)
            .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
            .build()
    }
}