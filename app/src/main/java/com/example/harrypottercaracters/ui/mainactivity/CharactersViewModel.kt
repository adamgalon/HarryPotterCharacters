package com.example.harrypottercaracters.ui.mainactivity

import androidx.lifecycle.*
import com.example.harrypottercaracters.data.models.Character
import com.example.harrypottercaracters.data.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {
    val characters = repository.getCharacters()

}