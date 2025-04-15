package com.netexlearning.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.netexlearning.pokemon.data.local.converters.PokemonTypeConverters
import com.netexlearning.pokemon.data.local.dao.PokemonDao
import com.netexlearning.pokemon.data.local.entities.pokemonfavorite.PokemonFavoriteEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.pokemonlist.PokemonListEntity

@Database(
    entities = [
        PokemonDetailEntity::class,
        PokemonListEntity::class,
        PokemonFavoriteEntity::class
    ],
    version = 7,
    exportSchema = false
)
@TypeConverters(PokemonTypeConverters::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}