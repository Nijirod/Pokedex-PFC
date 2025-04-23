package com.netexlearning.pokemon.api

import com.netexlearning.pokemon.PokemonList

data class PokemonApiResponse(
    val results: List<PokemonList>
)