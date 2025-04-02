package com.netexlearning.pokemon

data class PokemonDetail(
    val id: String,
    val order: String,
    val name: String,
    val species: String,
    val types: List<String>,
    val forms: List<String>,
    val isDefault: Boolean,
    val cries: String,
    val spritesURLs: List<Int>,
    val abilities: List<String>,
    val stats: List<String>,
    val weight: String,
    val height: String,
)

val samplePokemonDetail =(
        PokemonDetail(
            id = "1",
            order = "1",
            name = "bulbasaur",
            species = "bulbasaur    ",
            types = listOf("grass", "poison"),
            forms = listOf("bulbasaur"),
            isDefault = true,
            cries = "https://pokeapi.co/api/v2/pokemon/1/cries/",
            spritesURLs = listOf(R.drawable.bulbasaur),
            abilities = listOf("overgrow", "chlorophyll"),
            stats = listOf("45", "49", "49", "65", "65", "45"),
            weight = "6.9 kg",
            height = "0.7 m"
        ))