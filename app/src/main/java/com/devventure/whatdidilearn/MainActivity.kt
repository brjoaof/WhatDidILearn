package com.devventure.whatdidilearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devventure.whatdidilearn.data.LearnedItemDatabase
import com.devventure.whatdidilearn.databinding.ActivityMainBinding
import com.devventure.whatdidilearn.view.LearnedItemAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.learnedItensRecyclerView
        val adapter = LearnedItemAdapter()
        adapter.learnedItems = LearnedItemDatabase.getAll()
        recycler.adapter = adapter
    }
}