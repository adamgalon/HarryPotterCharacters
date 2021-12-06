package com.example.harrypottercaracters.data.repository

import com.example.harrypottercaracters.data.local.CharacterDao
import com.example.harrypottercaracters.data.remote.CharacterRemoteDataSource
import com.example.harrypottercaracters.utils.performGetOperation

class CharactersRepository(
    var remoteDataSource: CharacterRemoteDataSource,
    var localDataSource: CharacterDao
) {

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    fun getCharacter(id: Int) = localDataSource.getCharacter(id)

}

