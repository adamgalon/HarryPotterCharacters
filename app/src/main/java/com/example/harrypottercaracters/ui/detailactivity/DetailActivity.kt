package com.example.harrypottercaracters.ui.detailactivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.harrypottercaracters.data.models.Character
import com.example.harrypottercaracters.databinding.DetailActivityBinding
import com.example.harrypottercaracters.ui.mainactivity.CharactersViewModel

class DetailActivity : AppCompatActivity() {
    lateinit var binding: DetailActivityBinding
    private lateinit var viewModel: CharactersViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val intent = intent.getSerializableExtra("character") as? Character
//        binding.speciesText.text = intent.toString()


    }
}