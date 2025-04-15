package com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities

data class SpritesEntity(
    val frontDefault: String,
    val backDefault: String,
    val frontShiny: String,
    val backShiny: String,
    val frontFemale: String,
    val backFemale: String,
    val frontShinyFemale: String,
    val backShinyFemale: String,
    val versions: VersionsSpritesEntity,
)