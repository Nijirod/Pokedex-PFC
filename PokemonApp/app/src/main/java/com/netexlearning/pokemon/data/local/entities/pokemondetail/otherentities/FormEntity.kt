package com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "form", primaryKeys = ["pokemonId"])
class FormEntity(
    val pokemonId: Int,
    val name: String? = null,
    val url: String? = null
)
