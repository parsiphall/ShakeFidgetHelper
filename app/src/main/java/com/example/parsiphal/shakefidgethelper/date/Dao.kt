package com.example.parsiphal.shakefidgethelper.date

import android.arch.persistence.room.*
import android.arch.persistence.room.Dao

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMonster(dungeonTable: DungeonTable)

    @Query("SELECT * FROM dungeontable WHERE dungeonNumber = :dungeonNumber AND stageNumber = :stageNumber")
    fun getMonsterInfo(dungeonNumber: Int, stageNumber: Int): DungeonTable

    @Delete
    fun deleteMonster(dungeonTable: DungeonTable)
}