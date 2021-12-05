package com.example.harrypottercaracters.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharactersItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val actor: String,
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
)

//    @SerializedName("alternate_actors")
//    val alternateActors: List<Any>,
//    @SerializedName("alternate_names")
//    val alternateNames: List<Any>,


//    val wand: Wand,
