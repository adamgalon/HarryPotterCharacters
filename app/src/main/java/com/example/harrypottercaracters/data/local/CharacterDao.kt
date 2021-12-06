package com.example.harrypottercaracters.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.harrypottercaracters.data.models.Character

@Dao
interface CharacterDao {

    @Query("SELECT * FROM characters")
    fun getAllCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE id=:id ")
    fun getCharacter(id: Int): Character

    @Query("SELECT * FROM characters ORDER BY name ASC")
    fun getStudentCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE hogwartsStaff = 1  ORDER BY name ASC")
    fun getStaffCharacters(): LiveData<List<Character>>

    @Query("SELECT * FROM characters WHERE house=\"Gryffindor\" ORDER BY name ASC")
    fun getByHouseCharacters(): LiveData<List<Character>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<Character>)

}