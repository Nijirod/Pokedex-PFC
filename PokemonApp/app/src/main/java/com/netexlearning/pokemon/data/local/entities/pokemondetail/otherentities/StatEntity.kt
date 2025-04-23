package com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon_stat", primaryKeys = ["pokemonId", "name"])
data class StatEntity(
    val pokemonId: Int,
    val name: String,
    val value: Int?
)