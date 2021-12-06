package com.example.harrypottercaracters.data.remote

import com.example.harrypottercaracters.data.models.CharactersItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterService {

    @GET("/api/characters")
    suspend fun getAllCharacters(): Response<List<CharactersItem>>
}