package com.netexlearning.pokemon.api.generations

class GenerationIII(
    val emerald: Emerald?,
    val firered_leafgreen: FireredLeafgreen?,
    val ruby_sapphire: RubySapphire?
) {
    data class Emerald(
        val front_default: String?,
        val front_shiny: String?
    )

    data class FireredLeafgreen(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?
    )

    data class RubySapphire(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?
    )

}
