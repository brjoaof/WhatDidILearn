package com.devventure.whatdidilearn

import android.app.Application
import com.devventure.whatdidilearn.data.LearnedItemRepository
import com.devventure.whatdidilearn.data.database.LearnedItemDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WhatDidILearnedApplication: Application() {
    val database by lazy {
        LearnedItemDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO))
    }

    val repository by lazy {
        LearnedItemRepository(database.learnedItemDao())
    }

}