package com.example.harrypottercaracters.ui.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.harrypottercaracters.R
import com.example.harrypottercaracters.data.local.AppDatabase
import com.example.harrypottercaracters.data.remote.CharacterRemoteDataSource
import com.example.harrypottercaracters.data.remote.RetrofitInstance
import com.example.harrypottercaracters.data.repository.CharactersRepository
import com.example.harrypottercaracters.databinding.ActivityMainBinding
import com.example.harrypottercaracters.adapters.CharactersAdapter
import com.example.harrypottercaracters.data.models.CharactersItem
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

        viewModel.getAllCharacters.observe(this, {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (it.data != null) adapter.setData(it.data)
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT)
                        .show()
                }
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

    override fun onClickedCharacter(character: CharactersItem) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("character", character)
        }
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.characters_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.all_characters -> {
                viewModel.getAll.observe(this, Observer {
                    adapter.setData(it)
                })
                true
            }

            R.id.student_characters -> {
                viewModel.getByStudent.observe(this, Observer {
                    adapter.setData(it)
                })

                true
            }
            R.id.staff_characters -> {
                Toast.makeText(baseContext, "Staff Characters", Toast.LENGTH_SHORT).show()
                viewModel.getStaff.observe(this, Observer {
                    adapter.setData(it)
                })
                true
            }
            R.id.house_characters -> {
                true
            }
            R.id.by_gryffindor -> {
                viewModel.getByHouse("Gryffindor").observe(this, Observer {
                    adapter.setData(it)

                })
                true
            }
            R.id.by_Hufflepuff -> {
                viewModel.getByHouse("Hufflepuff").observe(this, Observer {
                    adapter.setData(it)

                })
                true
            }
            R.id.by_slytherin -> {
                viewModel.getByHouse("Slytherin").observe(this, Observer {
                    adapter.setData(it)

                })
                true
            }
            R.id.by_Ravenclaw -> {
                viewModel.getByHouse("Ravenclaw").observe(this, Observer {
                    adapter.setData(it)

                })
                true
            }


            else -> return super.onOptionsItemSelected(item)

        }
    }

}
