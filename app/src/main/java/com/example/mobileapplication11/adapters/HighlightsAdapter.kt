package com.example.mobileapplication11.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mobileapplication11.R
import com.example.mobileapplication11.databinding.ItemStoryBinding
import com.example.mobileapplication11.models.Highlights

class HighlightsAdapter : ListAdapter<Highlights, HighlightsAdapter.Holder>(Comparator()) {

    class Holder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemStoryBinding.bind(view)
        fun bind(item: Highlights)= with(binding){
            tvHText.text = item.text
        }
    }

    class Comparator: DiffUtil.ItemCallback<Highlights>(){
        override fun areItemsTheSame(oldItem: Highlights, newItem: Highlights): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Highlights, newItem: Highlights): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_story, parent, false)
        return Holder(view)
    } // ქმნით

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    } // ავსებთ

}