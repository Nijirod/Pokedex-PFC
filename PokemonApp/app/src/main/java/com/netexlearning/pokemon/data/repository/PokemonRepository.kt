package com.netexlearning.pokemon.data.repository

import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.api.PokemonApiServiceInterface
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokemonApiServiceInterface
){
    suspend fun getPokemonList(): List<Unit> {
        val apiResponse = apiService.getPokemonList()
        return apiResponse.map { PokemonMapper.fromApiResponse(it) }
    }
    suspend fun getPokemonDetail(id: Int): PokemonDetail {
        val detailResponse = apiService.getPokemonDetail(id)
        return PokemonMapper.fromDetailResponse(detailResponse)
    }
}