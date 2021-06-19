package com.devventure.whatdidilearn.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devventure.whatdidilearn.R
import com.devventure.whatdidilearn.data.LearnedItem
import com.devventure.whatdidilearn.data.UnderstandingLevel

class LearnedItemAdapter: RecyclerView.Adapter<LearnedItemAdapter.LearnedItemViewHolder>() {
    var learnedItems = listOf<LearnedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearnedItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.learned_item, parent, false)

        return LearnedItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: LearnedItemViewHolder, position: Int) {
        val learnedItem = learnedItems[position]
        holder.bind(learnedItem)
    }

    override fun getItemCount(): Int {
        return learnedItems.size
    }

    inner class LearnedItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val titleContainer: TextView = itemView.findViewById(R.id.item)
        private val descriptionContainer: TextView = itemView.findViewById(R.id.description)
        private val levelContainer: View = itemView.findViewById(R.id.level)

        fun bind(learnedItem: LearnedItem) {
            titleContainer.text = learnedItem.name
            descriptionContainer.text = learnedItem.description
            levelContainer.setBackgroundResource(learnedItem.understandingLevel.color)
        }

    }

}
