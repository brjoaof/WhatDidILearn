package com.devventure.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.devventure.whatdidilearn.WhatDidILearnedApplication
import com.devventure.whatdidilearn.databinding.ActivityMainBinding
import com.devventure.whatdidilearn.viewmodel.MainViewModel
import com.devventure.whatdidilearn.viewmodel.ViewModelFactory

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

        val viewModelFactory = ViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        val items = viewModel.learnedItems

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