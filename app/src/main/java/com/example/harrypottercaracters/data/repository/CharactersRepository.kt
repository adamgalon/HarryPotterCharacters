package com.example.harrypottercaracters.data.repository

import com.example.harrypottercaracters.data.local.CharacterDao
import com.example.harrypottercaracters.data.models.Character
import com.example.harrypottercaracters.data.remote.CharacterRemoteDataSource
import com.example.harrypottercaracters.data.remote.RetrofitInstance
import com.example.harrypottercaracters.utils.performGetOperation
import retrofit2.Response

class CharactersRepository(
    var remoteDataSource: CharacterRemoteDataSource,
    var localDataSource: CharacterDao
) {

    fun getCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getCharacters() },
        saveCallResult = { localDataSource.insertAll(it) }
    )


    suspend fun getAllCharacters(): Response<ArrayList<Character>> {
        return RetrofitInstance.apiCall.getAllCharacters()
    }


}


//    val getAllCharactersInDatabase: LiveData<ArrayList<Character>> = characterDao.getCharacters()
//
//    suspend fun addCharactersInDatabase(list: ArrayList<Character>) {
//        characterDao.addAll(list)
//    }