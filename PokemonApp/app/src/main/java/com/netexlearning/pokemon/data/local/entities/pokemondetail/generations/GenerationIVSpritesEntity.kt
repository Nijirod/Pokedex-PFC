package com.netexlearning.pokemon.data.local.entities.pokemondetail.generations


data class GenerationIVSpritesEntity(
    val diamond_pearl: SharedSpritesEntity,
    val heartgold_soulsilver: SharedSpritesEntity,
    val platinum: SharedSpritesEntity
){
    data class SharedSpritesEntity(
        val back_default: String?,
        val back_female: String?,
        val back_shiny: String?,
        val back_shiny_female: String?,
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_shiny_female: String?
    )
}
