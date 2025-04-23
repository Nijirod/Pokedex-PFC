package com.netexlearning.pokemon.api.generations

import com.netexlearning.pokemon.data.mapper.interfaces.IGame
import com.netexlearning.pokemon.data.mapper.interfaces.IGeneration

class GenerationII (
    val crystal: CrystalSprites?,
    val gold: BasicShinySprites?,
    val silver: BasicShinySprites?
): IGeneration {
    data class CrystalSprites(
        val back_default: String?,
        val back_shiny: String?,
        val back_shiny_transparent: String?,
        val back_transparent: String?,
        val front_default: String?,
        val front_shiny: String?,
        val front_shiny_transparent: String?,
        val front_transparent: String?
    ): IGame

    data class BasicShinySprites(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?,
        val front_transparent: String?
    ): IGame
}
