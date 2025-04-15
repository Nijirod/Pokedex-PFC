package com.netexlearning.pokemon.data.local.entities

data class PokemonListWithFavoriteEntity(
    val id: Int,
    val name: String,
    val url: String?,
    val isFavorite: Boolean
)