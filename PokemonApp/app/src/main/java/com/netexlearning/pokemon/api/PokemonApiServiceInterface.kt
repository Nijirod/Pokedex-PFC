package com.netexlearning.pokemon.api

import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiServiceInterface {

    @GET("pokemon")
    suspend fun getPokemonList(): List<PokemonApiResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetailResponse


}