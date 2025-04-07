package com.netexlearning.pokemon.api

data class PokemonDetailResponse(
    val id: Int?,
    val order: Int?,
    val name: String?,
    val species: Species?,
    val types: List<Type>?,
    val form: Form?,
    val is_default: Boolean?,
    val cries: Cries?,
    val sprites: Sprites?,
    val abilities: List<Ability>?,
    val stats: List<Stats>?,
    val weight: Int?,
    val height: Int?
)

data class Species(
    val name: String,
    val url: String
)

data class Type(
    val slot: Int,
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
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class Ability(
    val ability: AbilityDetail,
    val is_hidden: Boolean,
    val slot: Int
)

data class AbilityDetail(
    val name: String,
    val url: String
)

data class Stats(
    val base_stat: Int,
    val effort: Int,
    val stat: Stat
)

data class Stat(
    val name: String,
    val url: String
)