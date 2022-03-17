package com.nazirov.cardsforexam.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUser(cardDB:CardDB)

    @Query("SELECT * FROM cards")
    fun getUsers():List<CardDB>

    @Query("DELETE FROM cards")
    fun deleteAllUsers()

}