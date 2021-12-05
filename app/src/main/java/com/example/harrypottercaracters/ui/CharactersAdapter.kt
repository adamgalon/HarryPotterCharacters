package com.example.harrypottercaracters.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.harrypottercaracters.R
import com.example.harrypottercaracters.data.models.Character
import com.example.harrypottercaracters.databinding.ItemCharacterBinding

class CharactersAdapter : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private val charactersItems = ArrayList<Character>()

    fun setData(items: List<Character>) {
        charactersItems.clear()
        charactersItems.addAll(items)
        notifyDataSetChanged()
    }


    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var character: Character

        fun bind(item: Character) {

            character = item
            binding.apply {
                Glide.with(binding.root)
                    .load(item.image.toUri().buildUpon().scheme("https").build())
                    .error(R.drawable.ic_launcher_foreground)
                    .into(binding.image)
                name.text = item.name
                house.text = item.house
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(charactersItems[position])

    }

    override fun getItemCount(): Int = charactersItems.size
}