package com.netexlearning.pokemon

data class Pokemon(val id: String, val name: String, val url: String?, val imageResourceURL: String?)

val pokemonList = listOf(
    Pokemon("1", "bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png"),
    Pokemon("2", "ivysaur", "https://pokeapi.co/api/v2/pokemon/2/", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png"),
    Pokemon("3", "venusaur", "https://pokeapi.co/api/v2/pokemon/3/", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/3.png"),
    Pokemon("4", "charmander", "https://pokeapi.co/api/v2/pokemon/4/", null),
    Pokemon("5", "charmeleon", "https://pokeapi.co/api/v2/pokemon/5/", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/5.png")
)
