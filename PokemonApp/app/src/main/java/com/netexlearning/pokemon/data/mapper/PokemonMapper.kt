package com.netexlearning.pokemon.data.mapper

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.Stat
import com.netexlearning.pokemon.api.*
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.AbilityEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.CriesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.FormEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.PokemonDetailEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.SpeciesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.SpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.StatEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.TypeEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.VersionsSpritesEntity
import com.netexlearning.pokemon.data.local.entities.pokemondetail.otherentities.AbilityDetailEntity
import com.netexlearning.pokemon.data.local.entities.pokemonlist.PokemonListEntity

object PokemonMapper {

    fun fromApiResponse(apiResponse: PokemonApiResponse): List<Pokemon> {
        return apiResponse.results.map { result ->
            Pokemon(
                name = result.name,
                url = result.url
            )
        }
    }

    fun fromDetailResponse(detailResponse: PokemonDetailResponse): PokemonDetail {
        return PokemonDetail(
            id = detailResponse.id,
            order = detailResponse.order,
            name = detailResponse.name,
            species = detailResponse.species?.let { Species(it.name, it.url) },
            types = detailResponse.types?.map { TypeName(it.type?.name, it.type?.url) },
            form = detailResponse.form?.let { Form(it.name, it.url) },
            isDefault = detailResponse.is_default,
            cries = detailResponse.cries?.let { Cries(it.latest, it.legacy) },
            spritesURLs = detailResponse.sprites?.let { mapSprites(it) },
            abilities = detailResponse.abilities?.map { AbilityDetail(it.ability?.name,
                it.ability?.url
            ) },
            stats = detailResponse.stats?.map { Stat(it.stat?.name.toString(), it.effort.toString(), it.base_stat) },
            weight = "${detailResponse.weight} kg",
            height = "${detailResponse.height} m"
        )
    }

    fun PokemonDetail.toEntity(): PokemonDetailEntity {
        return PokemonDetailEntity(
            id = this.id,
            name = this.name ?: "",
            order = this.order ?: 0,
            species = this.species?.let { SpeciesEntity(it.name, it.url) },
            types = this.types?.map { TypeEntity(it.name.toString(), it.url.toString()) } ?: emptyList(),
            form = this.form?.let { FormEntity(it.name, it.url) },
            isDefault = this.isDefault ?: false,
            cries = this.cries?.let { CriesEntity(it.latest, it.legacy) },
            spritesURLs = this.spritesURLs?.let { mapSpritesToEntity(it) },
            abilities = this.abilities?.map { AbilityEntity(ability = AbilityDetailEntity(
                it.name.toString(),
                it.url.toString()
            )
            ) } ?: emptyList(),
            stats = this.stats?.map { StatEntity(it.name, it.value) } ?: emptyList(),
            height = this.height,
            weight = this.weight?.replace(" kg", "")?.toIntOrNull() ?: 0,
        )
    }

    fun PokemonDetailEntity.toDomain(): PokemonDetail {
        return PokemonDetail(
            id = this.id,
            name = this.name,
            order = this.order,
            species = this.species?.let { Species(it.name.toString(), it.url.toString()) },
            types = this.types?.map { TypeName(it.name, it.url) },
            form = this.form?.let { Form(it.name.toString(), it.url.toString()) },
            isDefault = this.isDefault,
            cries = this.cries?.let { Cries(it.latest.toString(), it.legacy.toString()) },
            spritesURLs = this.spritesURLs?.let { mapSpritesFromEntity(it) },
            abilities = this.abilities?.map { AbilityDetail(it.ability.name, it.ability.url) },
            stats = this.stats?.map { Stat(it.name, "0", it.value) },
            height = this.height,
            weight = "${this.weight} kg"
        )
    }

    fun fromListEntityToDetailEntity(entity: PokemonListEntity): PokemonDetailEntity {
            return PokemonDetailEntity(
                id = entity.id,
                name = entity.name,
                order = null,
                species = null,
                types = null,
                form = null,
                isDefault = null,
                cries = null,
                spritesURLs = null,
                abilities = null,
                stats = null,
                height = null,
                weight = null
            )
    }
    private fun mapSprites(sprites: Sprites): Sprites {
        return Sprites(
            back_default = sprites.back_default,
            back_female = sprites.back_female,
            back_shiny = sprites.back_shiny,
            back_shiny_female = sprites.back_shiny_female,
            front_default = sprites.front_default,
            front_female = sprites.front_female,
            front_shiny = sprites.front_shiny,
            front_shiny_female = sprites.front_shiny_female,
            versions = sprites.versions 
        )
    }

    private fun mapSpritesToEntity(sprites: Sprites): SpritesEntity {
        return SpritesEntity(
            frontDefault = sprites.front_default ?: "",
            backDefault = sprites.back_default ?: "",
            frontShiny = sprites.front_shiny ?: "",
            backShiny = sprites.back_shiny ?: "",
            frontFemale = sprites.front_female ?: "",
            backFemale = sprites.back_female ?: "",
            frontShinyFemale = sprites.front_shiny_female ?: "",
            backShinyFemale = sprites.back_shiny_female ?: "",
            versions = VersionsSpritesEntity(
                generationI = GenerationMapper.mapGenerationI(sprites.versions?.generation_i),
                generationII = GenerationMapper.mapGenerationII(sprites.versions?.generation_ii),
                generationIII = GenerationMapper.mapGenerationIII(sprites.versions?.generation_iii),
                generationIV = GenerationMapper.mapGenerationIV(sprites.versions?.generation_iv),
                generationV = GenerationMapper.mapGenerationV(sprites.versions?.generation_v),
                generationVI = GenerationMapper.mapGenerationVI(sprites.versions?.generation_vi),
                generationVII = GenerationMapper.mapGenerationVII(sprites.versions?.generation_vii),
                generationVIII = GenerationMapper.mapGenerationVIII(sprites.versions?.generation_viii)
            )
        )
    }

    private fun mapSpritesFromEntity(spritesEntity: SpritesEntity): Sprites {
        return Sprites(
            front_default = spritesEntity.frontDefault,
            back_default = spritesEntity.backDefault,
            front_shiny = spritesEntity.frontShiny,
            back_shiny = spritesEntity.backShiny,
            front_female = spritesEntity.frontFemale,
            back_female = spritesEntity.backFemale,
            front_shiny_female = spritesEntity.frontShinyFemale,
            back_shiny_female = spritesEntity.backShinyFemale,
            versions = Versions(
                generation_i = GenerationMapper.mapGenerationIFromEntity(spritesEntity.versions.generationI),
                generation_ii = GenerationMapper.mapGenerationIIFromEntity(spritesEntity.versions.generationII),
                generation_iii = GenerationMapper.mapGenerationIIIFromEntity(spritesEntity.versions.generationIII),
                generation_iv = GenerationMapper.mapGenerationIVFromEntity(spritesEntity.versions.generationIV),
                generation_v = GenerationMapper.mapGenerationVFromEntity(spritesEntity.versions.generationV),
                generation_vi = GenerationMapper.mapGenerationVIFromEntity(spritesEntity.versions.generationVI),
                generation_vii = GenerationMapper.mapGenerationVIIFromEntity(spritesEntity.versions.generationVII),
                generation_viii = GenerationMapper.mapGenerationVIIIFromEntity(spritesEntity.versions.generationVIII)
            )
        )
    }

}