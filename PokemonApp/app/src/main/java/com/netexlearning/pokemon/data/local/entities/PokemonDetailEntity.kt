package com.netexlearning.pokemon.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.netexlearning.pokemon.data.local.converters.PokemonTypeConverters

@Entity(tableName = "pokemon_detail")
@TypeConverters(PokemonTypeConverters::class)
data class PokemonDetailEntity(
    @PrimaryKey val id: Int?,
    val name: String?,
    val order: Int?,
    val species: SpeciesEntity?,
    val types: List<TypeEntity>?,
    val form: FormEntity?,
    val isDefault: Boolean?,
    val cries: CriesEntity?,
    val spritesURLs: SpritesEntity?,
    val abilities: List<AbilityEntity>?,
    val stats: List<StatEntity>?,
    val height: String?,
    val weight: Int?,
)