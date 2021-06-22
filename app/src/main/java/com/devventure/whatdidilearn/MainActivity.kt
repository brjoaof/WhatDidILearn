package com.devventure.whatdidilearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devventure.whatdidilearn.data.LearnedItem
import com.devventure.whatdidilearn.data.LearnedItemDatabase
import com.devventure.whatdidilearn.data.UnderstandingLevel
import com.devventure.whatdidilearn.databinding.ActivityMainBinding
import com.devventure.whatdidilearn.view.LearnedItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "What Did I Learn"

        val recycler = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()
        adapter.learnedItems = LearnedItemDatabase.getAll()
        recycler.adapter = adapter

        val fab = binding.fabMain
        fab.setOnClickListener {
            val intent = Intent(this, NewItem::class.java)
            startActivity(intent)
        }

        val database = (application as WhatDidILearnedApplication).databese
        database.learnedItemDao().insert(
            LearnedItem(
                name = "Item de Teste",
                description = "Será que vai funcionar?",
                understandingLevel = UnderstandingLevel.LOW
            )
        )

    }
}