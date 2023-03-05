package com.example.programming_language

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.programming_language.databinding.ItemLanguageBinding

class ListLanguageAdapter(private val listLanguage: ArrayList<Language>, private val onClick: (Language) -> Unit) : RecyclerView.Adapter<ListLanguageAdapter.ListViewHolder>() {
    class ListViewHolder(var binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListLanguageAdapter.ListViewHolder {
        val binding = ItemLanguageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListLanguageAdapter.ListViewHolder, position: Int) {
        val (name, desc, photo) = listLanguage[position]
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = desc
        holder.binding.imgItemPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {onClick(listLanguage[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listLanguage.size
    }
}