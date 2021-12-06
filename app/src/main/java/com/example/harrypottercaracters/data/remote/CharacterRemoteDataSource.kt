package com.example.harrypottercaracters.data.remote

class CharacterRemoteDataSource(
    private val characterService: CharacterService
) : BaseDataSource() {

    suspend fun getAllCharacters() = getResult { characterService.getAllCharacters() }

}