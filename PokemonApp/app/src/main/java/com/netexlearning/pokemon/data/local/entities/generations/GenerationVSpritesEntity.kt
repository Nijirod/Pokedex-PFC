package com.netexlearning.pokemon.data.local.entities.generations

data class GenerationVSpritesEntity(
    val black_white: BlackWhiteSpritesEntity,
){
    data class BlackWhiteSpritesEntity(
        val animated: AnimatedSpritesEntity,
        val back_default: String?,
        val back_female: String?,
        val back_shiny: String?,
        val back_shiny_female: String?,
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_shiny_female: String?
    )
    data class AnimatedSpritesEntity(
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
