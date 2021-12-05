package com.example.harrypottercaracters.ui

import androidx.lifecycle.*
import com.example.harrypottercaracters.data.models.Character
import com.example.harrypottercaracters.data.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repository: CharactersRepository
) : ViewModel() {

//    private val _characters: MutableLiveData<ArrayList<Character>> = MutableLiveData()
//    val characters: LiveData<ArrayList<Character>>
//        get() = _characters

    val characters = repository.getCharacters()


//    init {
//        getAllCharactersTemporary()
//    }
//
//    private fun getAllCharactersTemporary() {
//        viewModelScope.launch {
//            val response = repository.getAllCharacters()
//            if (response.isSuccessful) {
//                _characters.value = response.body()
//            }
//        }
//
//    }


//    private fun insertCharacters(list: ArrayList<Character>) = viewModelScope.launch {
//        repository.addCharactersInDatabase(list)
//    }

}