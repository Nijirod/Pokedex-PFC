package com.netexlearning.pokemon.data.repository

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.api.PokemonApiServiceInterface
import com.netexlearning.pokemon.data.local.dao.PokemonDao
import com.netexlearning.pokemon.data.local.entities.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.PokemonListEntity
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokemonApiServiceInterface,
    private val pokemonDao: PokemonDao
) {
    suspend fun getPokemonListFromApi(limit: Int, offset: Int): List<Pokemon> {
        val apiResponse = apiService.getPokemonList(limit, offset)
        return PokemonMapper.fromApiResponse(apiResponse)
    }

    suspend fun getPokemonDetailFromApi(id: Int): PokemonDetail {
        val detailResponse = apiService.getPokemonDetail(id)
        return PokemonMapper.fromDetailResponse(detailResponse)
    }


    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonListEntity> {
        val response = apiService.getPokemonList(limit, offset)
        return response.results.map { pokemon ->
            PokemonListEntity(
                id = pokemon.id.toInt(),
                name = pokemon.name,
                isFavourite = pokemon.isFavorite
            )
        }
    }

    suspend fun insertPokemonList(pokemonList: List<PokemonListEntity>) {
        pokemonDao.insertPokemonList(pokemonList)
    }

    suspend fun updateFavouriteStatus(id: Int, isFavourite: Boolean) {
        pokemonDao.updateFavouriteStatus(id, isFavourite)
    }

    suspend fun getPokemonDetailFromDao(id: Int): PokemonDetailEntity? {
        return pokemonDao.getPokemonDetailById(id)
    }

    suspend fun insertPokemonDetail(pokemonDetail: PokemonDetailEntity) {
        pokemonDao.insertPokemonDetail(pokemonDetail)
    }

    suspend fun getPokemonByName(name: String): PokemonListEntity? {
        return pokemonDao.getPokemonByName(name)
    }
}