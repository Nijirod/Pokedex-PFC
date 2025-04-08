package com.netexlearning.pokemon.data.mapper

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.Stat
import com.netexlearning.pokemon.api.*

object PokemonMapper {
    fun fromDetailResponse(detailResponse: PokemonDetailResponse): PokemonDetail {
        return PokemonDetail(
            id = detailResponse.id,
            order = detailResponse.order,
            name = detailResponse.name,
            species = detailResponse.species?.let { Species(it.name, it.url) },
            types = detailResponse.types?.map { TypeName(it.type.name, it.type.url) },
            form = detailResponse.form?.let { Form(it.name, it.url) },
            isDefault = detailResponse.is_default,
            cries = detailResponse.cries?.let { Cries(it.latest, it.legacy) },
            spritesURLs = detailResponse.sprites?.let { mapSprites(it) },
            abilities = detailResponse.abilities?.map { AbilityDetail(it.ability.name, it.ability.url) },
            stats = detailResponse.stats?.map { Stat(it.stat.name, it.effort.toString(), it.base_stat) },
            weight = "${detailResponse.weight} kg",
            height = "${detailResponse.height} m"
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
            versions = sprites.versions?.let { mapVersions(it) }
        )
    }

    private fun mapVersions(versions: Versions): Versions {
        return Versions(
            generation_i = versions.generation_i,
            generation_ii = versions.generation_ii,
            generation_iii = versions.generation_iii,
            generation_iv = versions.generation_iv,
            generation_v = versions.generation_v,
            generation_vi = versions.generation_vi,
            generation_vii = versions.generation_vii,
            generation_viii = versions.generation_viii
        )
    }

    fun fromApiResponse(apiResponse: PokemonApiResponse): List<Pokemon> {
        return apiResponse.results.map { Pokemon(it.name, it.url) }
    }
}