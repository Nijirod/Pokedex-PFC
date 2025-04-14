package com.netexlearning.pokemon.data.local.dao

import androidx.room.*
import com.netexlearning.pokemon.data.local.entities.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.PokemonListEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonDetail(pokemonDetail: PokemonDetailEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonList(pokemonList: List<PokemonListEntity>)

    @Query("SELECT * FROM pokemon_list")
    suspend fun getAllPokemonList(): List<PokemonListEntity>

    @Query("SELECT * FROM pokemon_list WHERE name = :name")
    suspend fun getPokemonByName(name: String): PokemonListEntity?

    @Query("SELECT * FROM pokemon_list WHERE id = :id")
    suspend fun getPokemonListById(id: Int): PokemonListEntity?

    @Query("SELECT * FROM pokemon_list WHERE isFavourite = 1")
    suspend fun getFavoritePokemon(): List<PokemonListEntity>

    @Query("UPDATE pokemon_list SET isFavourite = :isFavourite WHERE id = :id")
    suspend fun updateFavouriteStatus(id: Int, isFavourite: Boolean)

    @Query("SELECT * FROM pokemon_detail WHERE id = :id")
    suspend fun getPokemonDetailById(id: Int): PokemonDetailEntity?

}