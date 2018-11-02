package com.example.parsiphal.shakefidgethelper

import android.app.Application
import android.arch.persistence.room.Room
import com.example.parsiphal.shakefidgethelper.date.DataBase

class MainApp : Application() {

    private lateinit var mDataBase: DataBase

    override fun onCreate() {
        super.onCreate()
        mDataBase = Room.databaseBuilder<DataBase>(applicationContext, DataBase::class.java, "helper_database").allowMainThreadQueries().build()
    }
}