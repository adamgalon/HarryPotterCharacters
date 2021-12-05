package com.example.harrypottercaracters.data.remote

class CharacterRemoteDataSource(
    private val characterService: CharacterService
) : BaseDataSource() {

    suspend fun getCharacters() = getResult { characterService.getAllCharacters() }

}