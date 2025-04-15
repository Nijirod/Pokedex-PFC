package com.netexlearning.pokemon.data.local.entities.pokemondetail.generations

data class GenerationIIISpritesEntity(
    val emerald: EmeraldSpritesEntity,
    val firered_leafgreen: IIIGenerationSpritesEntity,
    val ruby_sapphire: IIIGenerationSpritesEntity,
){
    data class EmeraldSpritesEntity(
        val front_default: String?,
        val front_shiny: String?
    )

    data class IIIGenerationSpritesEntity(
        val back_default: String?,
        val back_shiny: String?,
        val front_default: String?,
        val front_shiny: String?
    )
}
