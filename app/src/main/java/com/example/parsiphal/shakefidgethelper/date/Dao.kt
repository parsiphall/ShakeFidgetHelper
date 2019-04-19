package com.example.parsiphal.shakefidgethelper.date

import android.arch.persistence.room.*
import android.arch.persistence.room.Dao

@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addMonster(dungeonTable: DungeonTable)

    @Query("SELECT * FROM DungeonTable WHERE dungeonNumber LIKE :dungeonNumber")
    fun getMonstersInfo(dungeonNumber: Int): List<DungeonTable>

    @Delete
    fun deleteMonster(dungeonTable: DungeonTable)
}