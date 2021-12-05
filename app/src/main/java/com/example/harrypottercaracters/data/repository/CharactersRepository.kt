package com.example.harrypottercaracters.data.repository

import com.example.harrypottercaracters.data.models.CharactersItem
import com.example.harrypottercaracters.data.remote.RetrofitInstance
import retrofit2.Response

class CharactersRepository() {

    suspend fun getAllCharacters(): Response<ArrayList<CharactersItem>> {
        return RetrofitInstance.apiCall.getAllCharacters()
    }

}