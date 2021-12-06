package com.example.harrypottercaracters.ui.detailactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.harrypottercaracters.R
import com.example.harrypottercaracters.data.models.CharactersItem
import com.example.harrypottercaracters.databinding.DetailActivityBinding
import com.example.harrypottercaracters.ui.mainactivity.CharactersViewModel

class DetailActivity : AppCompatActivity() {
    lateinit var binding: DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getSerializableExtra("character") as? CharactersItem
        bind(intent)

    }

    fun bind(item: CharactersItem?) {
        binding.apply {
            Glide.with(binding.root)
                .load(item?.image?.toUri()?.buildUpon()?.scheme("https")?.build())
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.image)
            name.text = item?.name
            houseResult.text = item?.house
            dateOfBirth.text = item?.dateOfBirth
            actor.text = item?.actor

        }
    }
}