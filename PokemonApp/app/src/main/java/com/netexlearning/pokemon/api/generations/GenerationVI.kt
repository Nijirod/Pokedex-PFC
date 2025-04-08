package com.netexlearning.pokemon.api.generations

class GenerationVI(
    val omega_ruby_alpha_sapphire: OmegaRubyAlphaSapphire?,
    val x_y: XY?
) {
    data class OmegaRubyAlphaSapphire(
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_shiny_female: String?
    )
    data class XY(
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_shiny_female: String?
    )
}
