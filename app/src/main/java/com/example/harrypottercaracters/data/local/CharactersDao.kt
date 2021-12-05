package com.example.harrypottercaracters.data.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.harrypottercaracters.data.models.CharactersItem

//@Dao
//interface CharactersDao {
//
//    @Insert(onConflict = REPLACE)
//    suspend fun addAllCharacters(characters: List<CharactersItem>)
//
//    @Query("SELECT * FROM characters")
//    fun getAllCharacters(): LiveData<List<CharactersItem>>
//}