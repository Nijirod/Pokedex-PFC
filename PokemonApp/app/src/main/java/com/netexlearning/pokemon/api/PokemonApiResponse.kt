package com.netexlearning.pokemon.api

import com.netexlearning.pokemon.Pokemon

data class PokemonApiResponse(
    val results: List<Pokemon>
)