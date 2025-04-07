package com.netexlearning.pokemon.data.repository

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.api.PokemonApiServiceInterface
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokemonApiServiceInterface
){
    suspend fun getPokemonList(): List<Pokemon> {
        val apiResponse = apiService.getPokemonList()
        return PokemonMapper.fromApiResponse(apiResponse)
    }

    suspend fun getPokemonDetail(id: Int): PokemonDetail {
        val detailResponse = apiService.getPokemonDetail(id)
        return PokemonMapper.fromDetailResponse(detailResponse)
    }
}