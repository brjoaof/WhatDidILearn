package com.devventure.whatdidilearn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devventure.whatdidilearn.databinding.ActivityMainBinding
import com.devventure.whatdidilearn.view.LearnedItemAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "What Did I Learn"

//        Possível Soluçao para descobrir o espaço ocupado pela tabela
//        val f: File = context.getDatabasePath(dbName)
//        val dbSize: Long = f.length()

        val recycler = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter

        val repository = (application as WhatDidILearnedApplication).repository
        val items = repository.learnedItems

        items.observe(this, {
            adapter.learnedItems = it
        })

        val fab = binding.fabMain
        fab.setOnClickListener {
            val intent = Intent(this, NewItemActivity::class.java)
            startActivity(intent)
        }


    }
}