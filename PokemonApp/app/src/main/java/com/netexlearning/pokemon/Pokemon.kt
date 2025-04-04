package com.netexlearning.pokemon

data class Pokemon(
    val name: String,
    val url: String?,
    val isFavorite: Boolean = false,
    val imgUrlLocal: Int? = null
){
    private val id: String
        get() = url?.substringBeforeLast("/") ?: "Unknown"
    val urlImage: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}

val pokemonListMock = listOf(
    Pokemon("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/", false ,R.drawable.bulbasaur),
    Pokemon("ivysaur", "https://pokeapi.co/api/v2/pokemon/2/", false ,R.drawable.ivysaur),
    Pokemon("venusaur", "https://pokeapi.co/api/v2/pokemon/3/", false ,R.drawable.venusaur),
    Pokemon( "charmander", "https://pokeapi.co/api/v2/pokemon/4/", false , null),
    Pokemon( "charmeleon", "https://pokeapi.co/api/v2/pokemon/5/", false ,R.drawable.charmeleon)
)
