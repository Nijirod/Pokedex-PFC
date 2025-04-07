package com.netexlearning.pokemon

data class Pokemon(
    val name: String,
    val url: String?
){
    val id: String
        get() = url?.substringAfterLast("pokemon/")?.substringBeforeLast("/") ?: "Unknown"
    val urlImage: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}

