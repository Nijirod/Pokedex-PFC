package com.netexlearning.pokemon.data.local.entities.generations

data class GenerationISpritesEntity(
    val redBlue: BasicSpritesEntity,
    val yellow: BasicSpritesEntity,
){
    data class BasicSpritesEntity(
        val back_default: String?,
        val back_gray: String?,
        val back_transparent: String?,
        val front_default: String?,
        val front_gray: String?,
        val front_transparent: String?
    )
}
