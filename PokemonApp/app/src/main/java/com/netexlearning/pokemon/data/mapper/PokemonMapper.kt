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
            spritesURLs = Sprites(
                detailResponse.sprites?.back_default,
                detailResponse.sprites?.back_female,
                detailResponse.sprites?.back_shiny,
                detailResponse.sprites?.back_shiny_female,
                detailResponse.sprites?.front_default,
                detailResponse.sprites?.front_female,
                detailResponse.sprites?.front_shiny,
                detailResponse.sprites?.front_shiny_female,
            ),
            abilities = detailResponse.abilities?.map { AbilityDetail(it.ability.name, it.ability.url) },
            stats = detailResponse.stats?.map { Stat(it.stat.name, it.effort.toString(), it.base_stat) },
            weight = "${detailResponse.weight} kg",
            height = "${detailResponse.height} m"
        )
    }

    fun fromApiResponse(apiResponse: PokemonApiResponse): List<Pokemon> {
        return apiResponse.results.map { Pokemon(it.name, it.url) }
    }
}