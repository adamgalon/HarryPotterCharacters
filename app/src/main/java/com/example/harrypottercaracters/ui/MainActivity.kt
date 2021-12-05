package com.example.harrypottercaracters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypottercaracters.data.repository.CharactersRepository
import com.example.harrypottercaracters.databinding.ActivityMainBinding
import com.example.harrypottercaracters.utils.CharactersViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = CharactersRepository()
        val viewModelFactory = CharactersViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharactersViewModel::class.java)


        setupRecyclerView()
        viewModel.characters.observe(this, Observer { characterList ->
            adapter.setData(characterList)
        })


    }


    private fun setupRecyclerView() {
        adapter = CharactersAdapter()
        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
    }

}