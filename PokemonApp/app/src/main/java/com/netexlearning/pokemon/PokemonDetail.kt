package com.netexlearning.pokemon

import com.netexlearning.pokemon.api.Ability
import com.netexlearning.pokemon.api.Cries
import com.netexlearning.pokemon.api.Form
import com.netexlearning.pokemon.api.Species
import com.netexlearning.pokemon.api.Sprites
import com.netexlearning.pokemon.api.TypeName

data class PokemonDetail(
    val id: Int?,
    val order: Int?,
    val name: String?,
    val species: Species?,
    val types: List<TypeName>?,
    val form: Form?,
    val isDefault: Boolean?,
    val cries: Cries?,
    val spritesURLs: Sprites?,
    val abilities: List<Ability>?,
    val stats: List<StatDetail>?,
    val weight: String?,
    val height: String?,
)

data class StatDetail(
    val name: String,
    val value: Int
)

val samplePokemonDetail = PokemonDetail(
    id = 1,
    order = 1,
    name = "bulbasaur",
    species = (Species(
        "bulbasaur",
        url = "https://pokeapi.co/api/v2/pokemon-species/1/")
    ),
    types = listOf(
        TypeName("grass", url = "https://pokeapi.co/api/v2/type/12/"),
        TypeName("poison", url = "https://pokeapi.co/api/v2/type/4/")
    ),
    form = (Form("bulbasaur", url = "https://pokeapi.co/api/v2/pokemon-form/1/")),
    isDefault = true,
    cries = (Cries(
        "https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/latest/1.ogg",
        "https://raw.githubusercontent.com/PokeAPI/cries/main/cries/pokemon/legacy/1.ogg")
    ),
    spritesURLs = (Sprites(
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png",
    null,
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/shiny/1.png",
        null,
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
    null,
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/1.png",
    null
    )),
    abilities = listOf(
        Ability("overgrow", url = "https://pokeapi.co/api/v2/ability/65/"),
        Ability("chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/" )
    ),
    stats = listOf(
        StatDetail("speed", 45),
        StatDetail("special-defense", 65),
        StatDetail("special-attack", 65),
        StatDetail("defense", 49),
        StatDetail("attack", 49),
        StatDetail("hp", 45)
    ),
    weight = "6.9 kg",
    height = "0.7 m"
)