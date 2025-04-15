package com.netexlearning.pokemon.data.repository

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.api.PokemonApiServiceInterface
import com.netexlearning.pokemon.data.local.dao.PokemonDao
import com.netexlearning.pokemon.data.local.entities.pokemondetail.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.pokemonlist.PokemonListEntity
import com.netexlearning.pokemon.data.local.entities.PokemonListWithFavoriteEntity
import com.netexlearning.pokemon.data.local.entities.pokemonfavorite.PokemonFavoriteEntity
import com.netexlearning.pokemon.data.mapper.PokemonMapper
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val apiService: PokemonApiServiceInterface,
    private val pokemonDao: PokemonDao
) {
    suspend fun getPokemonDetailFromApi(id: Int): PokemonDetail {
        val detailResponse = apiService.getPokemonDetail(id)
        return PokemonMapper.fromDetailResponse(detailResponse)
    }

    suspend fun fetchAndStorePokemonList(limit: Int, offset: Int): List<PokemonListEntity> {
        val apiResponse = apiService.getPokemonList(limit, offset)
        val pokemonList = apiResponse.results.map { pokemon ->
            PokemonListEntity(
                id = pokemon.id.toInt(),
                name = pokemon.name,
                url = pokemon.url,
            )
        }
        pokemonDao.insertPokemonList(pokemonList)
        return pokemonList
    }


    suspend fun updatePokemonFavoriteStatus(name: String, isFavorite: Boolean) {
        val pokemon = pokemonDao.getPokemonByName(name)
        if (pokemon != null) {
            val favoriteEntity = PokemonFavoriteEntity(
                id = pokemon.id,
                isFavorite = isFavorite
            )
            if (isFavorite) {
                pokemonDao.insertFavorite(favoriteEntity)
            } else {
                pokemonDao.deleteFavorite(pokemon.id)
            }
        }
    }


    suspend fun getAllPokemonList(limit: Int, offset: Int): List<PokemonListWithFavoriteEntity> {
        return pokemonDao.getAllPokemonList(limit, offset)
    }

    suspend fun getPokemonDetailFromDao(id: Int): PokemonDetailEntity? {
        return pokemonDao.getPokemonDetailById(id)
    }

    suspend fun insertPokemonDetail(pokemonDetail: PokemonDetailEntity) {
        pokemonDao.insertPokemonDetail(pokemonDetail)
    }

    suspend fun getPokemonByName(name: String): PokemonListWithFavoriteEntity? {
        return pokemonDao.getPokemonByName(name)
    }
}