package com.example.harrypottercaracters.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "character")
data class CharactersItem(
    @PrimaryKey val actor: String,
    val alive: Boolean,
    val ancestry: String,
    val dateOfBirth: String,
    val eyeColour: String,
    val gender: String,
    val hairColour: String,
    val hogwartsStaff: Boolean,
    val hogwartsStudent: Boolean,
    val house: String,
    val image: String,
    val name: String,
    val patronus: String,
    val species: String,
    val wizard: Boolean,
    val yearOfBirth: String
) : Serializable

//TODO: add TypeConverter
//    val wand: Wand,
