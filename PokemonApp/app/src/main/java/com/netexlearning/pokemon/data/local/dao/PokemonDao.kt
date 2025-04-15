package com.netexlearning.pokemon.data.local.dao

import androidx.room.*
import com.netexlearning.pokemon.data.local.entities.PokemonListWithFavoriteEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.pokemonfavorite.PokemonFavoriteEntity
import com.netexlearning.pokemon.data.local.entities.pokemonlist.PokemonListEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetail(pokemonDetail: PokemonDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<PokemonListEntity>)


    @Query("""
    SELECT
        pokemon_list.id,
        pokemon_list.name,
        pokemon_list.url,
        COALESCE(pokemon_favorite.isFavorite, 0) AS isFavorite
    FROM pokemon_list
    LEFT JOIN pokemon_favorite ON pokemon_list.id = pokemon_favorite.id
    LIMIT :limit OFFSET :offset
    """)
    suspend fun getAllPokemonList(limit: Int, offset: Int): List<PokemonListWithFavoriteEntity>

    @Query("""
    SELECT
        pokemon_list.id,
        pokemon_list.name,
        pokemon_list.url,
        COALESCE(pokemon_favorite.isFavorite, 0) AS isFavorite
    FROM pokemon_list
    LEFT JOIN pokemon_favorite ON pokemon_list.id = pokemon_favorite.id
    WHERE pokemon_list.name = :name
    """)
    suspend fun getPokemonByName(name: String): PokemonListWithFavoriteEntity?

    @Query("SELECT * FROM pokemon_list WHERE id = :id")
    suspend fun getPokemonListById(id: Int): PokemonListEntity?

    @Query("SELECT * FROM pokemon_detail WHERE id = :id")
    suspend fun getPokemonDetailById(id: Int): PokemonDetailEntity?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(pokemonFavorite: PokemonFavoriteEntity)

    @Query("DELETE FROM pokemon_favorite WHERE id = :id")
    suspend fun deleteFavorite(id: Int)
}