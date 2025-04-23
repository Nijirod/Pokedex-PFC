package com.netexlearning.pokemon.api.generations

import com.netexlearning.pokemon.data.mapper.interfaces.IGame
import com.netexlearning.pokemon.data.mapper.interfaces.IGeneration

class GenerationVIII (
    val icons : Icons?
): IGeneration {
    data class Icons(
        val front_default: String?,
        val front_female: String?
    ): IGame


}
