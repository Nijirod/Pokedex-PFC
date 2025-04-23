package com.netexlearning.pokemon

import com.netexlearning.pokemon.api.AbilityDetail
import com.netexlearning.pokemon.api.Cries
import com.netexlearning.pokemon.api.Form
import com.netexlearning.pokemon.api.Species
import com.netexlearning.pokemon.api.TypeName
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.SpritesEntity

data class PokemonDetail(
    val id: Int?,
    val order: Int?,
    val name: String?,
    val species: Species,
    val types: List<TypeName>?,
    val form: Form?,
    val isDefault: Boolean?,
    val cries: Cries?,
    val sprites: List<SpritesEntity>?,
    val abilities: List<AbilityDetail>?,
    val stats: List<Stat>?,
    val weight: String?,
    val height: String?
)

data class Stat(
    val name: String?,
    val value: Int?
)