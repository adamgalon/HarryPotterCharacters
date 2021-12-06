package com.example.harrypottercaracters.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.harrypottercaracters.data.models.CharactersItem

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<CharactersItem>)

    @Query("SELECT * FROM character ORDER BY name ASC ")
    fun getAllCharacters(): LiveData<List<CharactersItem>>

    @Query("SELECT * FROM character WHERE hogwartsStudent= 1 ORDER BY name ASC ")
    fun getStudentCharacters(): LiveData<List<CharactersItem>>

    @Query("SELECT * FROM character WHERE hogwartsStaff = 1  ORDER BY name ASC")
    fun getStaffCharacters(): LiveData<List<CharactersItem>>

    @Query("SELECT * FROM character WHERE house=:house ORDER BY name ASC")
    fun getByHouseCharacters(house: String): LiveData<List<CharactersItem>>
}



