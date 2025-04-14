package com.netexlearning.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.netexlearning.pokemon.data.local.converters.PokemonTypeConverters
import com.netexlearning.pokemon.data.local.dao.PokemonDao
import com.netexlearning.pokemon.data.local.entities.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.PokemonListEntity

@Database(entities = [PokemonDetailEntity::class, PokemonListEntity::class], version = 2, exportSchema = false)
@TypeConverters(PokemonTypeConverters::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}