package com.netexlearning.pokemon.data.local.entities.views

data class PokemonListWithFavoriteView(
    val id: Int,
    val name: String,
    val url: String?,
    val isFavorite: Boolean
)