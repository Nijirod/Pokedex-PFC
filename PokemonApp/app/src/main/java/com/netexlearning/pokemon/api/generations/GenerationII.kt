package com.netexlearning.pokemon.api.generations

class GenerationII (
    val crystal: Crystal?,
    val gold: Gold?,
    val silver: Silver?
){
    data class Crystal(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?
    )

    data class Gold(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?
    )

    data class Silver(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?
    )
}
