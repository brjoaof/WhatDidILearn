package com.devventure.whatdidilearn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LearnedItemDao {

    @Query("SELECT * FROM learned_item")
    fun getAll(): List<LearnedItem>

    @Insert
    fun insert(learnedItem: LearnedItem)
}