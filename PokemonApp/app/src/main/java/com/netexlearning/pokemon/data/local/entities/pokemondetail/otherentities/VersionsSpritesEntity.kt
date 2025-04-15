package com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities

import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationIIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationISpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationIVSpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationVIIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationVIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationVISpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.generations.GenerationVSpritesEntity

data class VersionsSpritesEntity(
    val generationI: GenerationISpritesEntity,
    val generationII: GenerationIISpritesEntity,
    val generationIII: GenerationIIISpritesEntity,
    val generationIV: GenerationIVSpritesEntity,
    val generationV: GenerationVSpritesEntity,
    val generationVI: GenerationVISpritesEntity,
    val generationVII: GenerationVIISpritesEntity,
    val generationVIII: GenerationVIIISpritesEntity,
)