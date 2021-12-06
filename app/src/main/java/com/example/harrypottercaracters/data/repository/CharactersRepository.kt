package com.example.harrypottercaracters.data.repository

import androidx.lifecycle.LiveData
import com.example.harrypottercaracters.data.local.CharacterDao
import com.example.harrypottercaracters.data.models.CharactersItem
import com.example.harrypottercaracters.data.remote.CharacterRemoteDataSource
import com.example.harrypottercaracters.utils.performGetOperation

class CharactersRepository(
    private var remoteDataSource: CharacterRemoteDataSource,
    private var localDataSource: CharacterDao
) {

    fun getAllCharacters() = performGetOperation(
        databaseQuery = { localDataSource.getAllCharacters() },
        networkCall = { remoteDataSource.getAllCharacters() },
        saveCallResult = { localDataSource.insertAll(it) }
    )

    val getAll = localDataSource.getAllCharacters()

    val byStudents = localDataSource.getStudentCharacters()

    val getStaff = localDataSource.getStaffCharacters()

    fun getByHouse(house: String): LiveData<List<CharactersItem>> {
        return localDataSource.getByHouseCharacters(house)
    }
}
