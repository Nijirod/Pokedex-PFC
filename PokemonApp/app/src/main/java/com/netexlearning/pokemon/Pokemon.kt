package com.netexlearning.pokemon

data class Pokemon(
    val name: String,
    val url: String?
){
    private val id: String
        get() = url?.substringBeforeLast("/") ?: "Unknown"
    val urlImage: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}

val pokemonList = listOf(
    Pokemon("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
    Pokemon("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/"),
    Pokemon("venusaur", "https://pokeapi.co/api/v2/pokemon/3/"),
    Pokemon( "charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
    Pokemon( "charmeleon", "https://pokeapi.co/api/v2/pokemon/5/")
)
