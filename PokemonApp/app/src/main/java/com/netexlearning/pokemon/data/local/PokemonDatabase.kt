package com.netexlearning.pokemon.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.netexlearning.pokemon.data.local.converters.PokemonTypeConverters
import com.netexlearning.pokemon.data.local.dao.PokemonDao
import com.netexlearning.pokemon.data.local.entities.pokemonfavorite.PokemonFavoriteEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.AbilityEntity
import com.netexlearning.pokemon.data.local.entities.pokemonlist.PokemonListEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.SpeciesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.CriesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.FormEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.SpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.StatEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.TypeEntity


@Database(
    entities = [
        PokemonDetailEntity::class,
        PokemonListEntity::class,
        PokemonFavoriteEntity::class,
        SpeciesEntity::class,
        AbilityEntity::class,
        CriesEntity::class,
        SpritesEntity::class,
        TypeEntity::class,
        StatEntity::class,
        FormEntity::class,

    ],
    version = 13,
    exportSchema = false
)
@TypeConverters(PokemonTypeConverters::class)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}