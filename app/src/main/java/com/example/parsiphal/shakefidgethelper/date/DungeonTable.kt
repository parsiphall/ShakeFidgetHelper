package com.example.parsiphal.shakefidgethelper.date

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class DungeonTable(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Long = 0,
    @ColumnInfo var dungeonNumber: Int = 0,
    @ColumnInfo var stageNumber: Int = 0,
    @ColumnInfo var enemyName: String = "",
    @ColumnInfo var level: String = "",
    @ColumnInfo var role: String = "",
    @ColumnInfo var strength: String = "",
    @ColumnInfo var agility: String = "",
    @ColumnInfo var intellegence: String = "",
    @ColumnInfo var vitality: String = "",
    @ColumnInfo var luck: String = "",
    @ColumnInfo var health: String = "",
    @ColumnInfo var experience: String = ""
)