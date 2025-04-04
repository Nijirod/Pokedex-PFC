package com.netexlearning.pokemon.api



data class PokemonDetailResponse(
    val id: Int?,
    val order: Int?,
    val name: String?,
    val species: Species?,
    val types: List<Type>?,
    val form: Form?,
    val isDefault: Boolean?,
    val cries: Cries?,
    val sprites: Sprites?,
    val abilities: List<Ability>?,
    val stats: List<Stat>?,
    val weight: Int?,
    val height: Int?
)

data class Species(
    val name: String,
    val url: String
)
data class Type(
    val type: TypeName
)
data class TypeName(
    val name: String,
    val url: String
)
data class Form(
    val name: String,
    val url: String
)
data class Cries(
    val latest: String,
    val legacy: String
)
data class Sprites(
    val backDefault: String?,
    val backFemale: String?,
    val backShiny: String?,
    val backShinyFemale: String?,
    val frontDefault: String?,
    val frontFemale: String?,
    val frontShiny: String?,
    val frontShinyFemale: String?
)
data class Ability(
    val name: String,
    val url: String,
)
data class Stat(
    val baseStat: Int,
    val stat: StatName
)
data class StatName(
    val name: String,
    val url: String
)