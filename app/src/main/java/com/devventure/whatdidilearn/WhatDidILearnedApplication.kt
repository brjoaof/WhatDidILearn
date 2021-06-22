package com.devventure.whatdidilearn

import android.app.Application
import com.devventure.whatdidilearn.data.LearnedItemDatabase

class WhatDidILearnedApplication: Application() {
    val databese by lazy { LearnedItemDatabase.getDatabase(this) }
}