package com.netexlearning.pokemon.data.local.entities

import com.netexlearning.pokemon.data.local.entities.generations.GenerationIIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationISpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationIVSpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationVIIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationVIISpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationVISpritesEntity
import com.netexlearning.pokemon.data.local.entities.generations.GenerationVSpritesEntity

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