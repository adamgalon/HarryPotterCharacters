package com.example.harrypottercaracters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypottercaracters.data.local.AppDatabase
import com.example.harrypottercaracters.data.local.CharacterDao
import com.example.harrypottercaracters.data.models.Character
import com.example.harrypottercaracters.data.remote.CharacterRemoteDataSource
import com.example.harrypottercaracters.data.remote.CharacterService
import com.example.harrypottercaracters.data.remote.RetrofitInstance
import com.example.harrypottercaracters.data.repository.CharactersRepository
import com.example.harrypottercaracters.databinding.ActivityMainBinding
import com.example.harrypottercaracters.utils.CharactersViewModelFactory
import com.example.harrypottercaracters.utils.Resource

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //correct
        val db = AppDatabase.invoke(this).characterDao()
        val retro = RetrofitInstance.service
        val remoteDataSource = CharacterRemoteDataSource(retro)
        val repository = CharactersRepository(remoteDataSource, db)
        val viewModelFactory = CharactersViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharactersViewModel::class.java)

        setupRecyclerView()

//        viewModel.characters.observe(this, Observer { characterList ->
//            adapter.setData(characterList)
//        })

        viewModel.characters.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) adapter.setData(it.data)
                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
            }
        })


    }


    private fun setupRecyclerView() {
        adapter = CharactersAdapter()
        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
    }

}