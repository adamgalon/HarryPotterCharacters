package com.example.harrypottercaracters.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.harrypottercaracters.data.models.CharactersItem
import com.example.harrypottercaracters.data.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

    private val _characters: MutableLiveData<ArrayList<CharactersItem>> = MutableLiveData()
    val characters: LiveData<ArrayList<CharactersItem>>
        get() = _characters


    init {
        getAllCharactersTemporary()
    }

    private fun getAllCharactersTemporary() {
        viewModelScope.launch {
            val response = repository.getAllCharacters()
            if (response.isSuccessful) {
                _characters.value = response.body()
            }
        }

    }
}