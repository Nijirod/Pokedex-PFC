package com.netexlearning.pokemon.data.local.entities.generations

data class GenerationIISpritesEntity(
    val crystal: CrystalSpritesEntity,
    val gold: BasicShinySpritesEntity,
    val silver: BasicShinySpritesEntity,
){
    data class CrystalSpritesEntity(
        val back_default: String?,
        val back_shiny: String?,
        val back_shiny_transparent: String?,
        val back_transparent: String?,
        val front_default: String?,
        val front_shiny: String?,
        val front_shiny_transparent: String?,
        val front_transparent: String?
    )

    data class BasicShinySpritesEntity(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?,
        val front_transparent: String?
    )
}
