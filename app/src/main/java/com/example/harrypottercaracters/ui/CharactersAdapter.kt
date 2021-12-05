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
import com.example.harrypottercaracters.data.models.CharactersItem

class CharactersAdapter : RecyclerView.Adapter<CharacterViewHolder>() {

    val charactersItems = ArrayList<CharactersItem>()

    fun setData(items: ArrayList<CharactersItem>) {
        charactersItems.clear()
        charactersItems.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.item_character,
                    parent,
                    false
                )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val url = charactersItems[position].image
        val uri = url.toUri().buildUpon().scheme("https").build()

        Glide.with(holder.itemView.context)
            .load(uri)
            .error(R.drawable.ic_launcher_foreground)
            .into(holder.ivCharacter)
        holder.tvName.text = charactersItems[position].name
        holder.tvHouse.text = charactersItems[position].house
    }

    override fun getItemCount(): Int = charactersItems.size

}

class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivCharacter: ImageView
    val tvName: TextView
    val tvHouse: TextView

    init {
        ivCharacter = view.findViewById(R.id.image)
        tvName = view.findViewById(R.id.name)
        tvHouse = view.findViewById(R.id.house)
    }


}
