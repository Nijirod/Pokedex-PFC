package com.netexlearning.pokemon

import com.netexlearning.pokemon.api.AbilityDetail
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
    val abilities: List<AbilityDetail>?,
    val stats: List<Stat>?,
    val weight: String?,
    val height: String?
)

data class Stat(
    val name: String,
    val effort: String,
    val value: Int?
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
        AbilityDetail("overgrow", url = "https://pokeapi.co/api/v2/ability/65/"),
        AbilityDetail("chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/" )
    ),
    stats = listOf(
        Stat("speed", "0",45),
        Stat("special-defense","0", 65),
        Stat("special-attack", "0",65),
        Stat("defense", "0",49),
        Stat("attack","0", 49),
        Stat("hp", "0",45)
    ),
    weight = "6.9 kg",
    height = "0.7 m"
)