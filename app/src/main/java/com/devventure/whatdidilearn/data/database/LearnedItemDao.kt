package com.devventure.whatdidilearn.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.devventure.whatdidilearn.entities.LearnedItem

@Dao
interface LearnedItemDao {

    @Query("SELECT * FROM learned_item")
    fun getAll(): LiveData<List<LearnedItem>>

    @Insert
    fun insert(item: LearnedItem)

    @Insert
    fun insert(item: List<LearnedItem>)
}