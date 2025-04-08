package com.netexlearning.pokemon.api.generations

class GenerationIV(
    val diamond_pearl: DiamondPearl?,
    val heartgold_soulsilver: HeartgoldSoulsilver?,
    val platinum: Platinum?
) {
    data class DiamondPearl(
        val back_default: String?,
        val back_female: String?,
        val back_shiny: String?,
        val back_shiny_female: String?,
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_female_shiny: String?
    )

    data class HeartgoldSoulsilver(
        val back_default: String?,
        val back_female: String?,
        val back_shiny: String?,
        val back_shiny_female: String?,
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_female_shiny: String?
    )
    data class Platinum(
        val back_default: String?,
        val back_female: String?,
        val back_shiny: String?,
        val back_shiny_female: String?,
        val front_default: String?,
        val front_female: String?,
        val front_shiny: String?,
        val front_female_shiny: String?
    )
}
