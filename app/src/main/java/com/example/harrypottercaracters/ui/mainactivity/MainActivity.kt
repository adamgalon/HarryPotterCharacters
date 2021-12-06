package com.example.harrypottercaracters.ui.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypottercaracters.R
import com.example.harrypottercaracters.data.local.AppDatabase
import com.example.harrypottercaracters.data.remote.CharacterRemoteDataSource
import com.example.harrypottercaracters.data.remote.RetrofitInstance
import com.example.harrypottercaracters.data.repository.CharactersRepository
import com.example.harrypottercaracters.databinding.ActivityMainBinding
import com.example.harrypottercaracters.ui.CharactersAdapter
import com.example.harrypottercaracters.ui.detailactivity.DetailActivity
import com.example.harrypottercaracters.utils.CharactersViewModelFactory
import com.example.harrypottercaracters.utils.Resource

class MainActivity : AppCompatActivity(), CharactersAdapter.CharacterItemListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharactersViewModel
    private lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModelFactory()
        setupRecyclerView()

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
        adapter = CharactersAdapter(this)
        binding.rvCharacters.adapter = adapter
        binding.rvCharacters.layoutManager = LinearLayoutManager(this)
    }

    private fun setupViewModelFactory() {
        //correct
        val repository = CharactersRepository(
            CharacterRemoteDataSource(RetrofitInstance.service),
            AppDatabase.invoke(this).characterDao()
        )
        val viewModelFactory = CharactersViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharactersViewModel::class.java)
    }

    override fun onClickedCharacter(characterId: Int) {

        Toast.makeText(baseContext, "clicked : $characterId", Toast.LENGTH_SHORT).show()
        Log.d("onClickedCharacter", characterId.toString())
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("character",characterId)
        }
        startActivity(intent)

    }


}
