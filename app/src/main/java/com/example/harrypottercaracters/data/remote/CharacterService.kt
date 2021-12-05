package com.example.harrypottercaracters.data.remote

import com.example.harrypottercaracters.data.models.Character
import retrofit2.Response
import retrofit2.http.GET

interface CharacterService {

    @GET("/api/characters")
    suspend fun getAllCharacters(): Response<ArrayList<Character>>


}