package com.netexlearning.pokemon.data.mapper

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.StatDetail
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
            isDefault = detailResponse.isDefault,
            cries = detailResponse.cries?.let { Cries(it.latest, it.legacy) },
            spritesURLs = Sprites(
                detailResponse.sprites?.frontDefault,
                detailResponse.sprites?.backDefault,
                detailResponse.sprites?.frontShiny,
                detailResponse.sprites?.backShiny,
                detailResponse.sprites?.frontFemale,
                detailResponse.sprites?.backFemale,
                detailResponse.sprites?.frontShinyFemale,
                detailResponse.sprites?.backShinyFemale
            ),
            abilities = detailResponse.abilities?.map { Ability(it.name, it.url) },
            stats = detailResponse.stats?.map { StatDetail(it.stat.name, it.baseStat) },
            weight = "${detailResponse.weight} kg",
            height = "${detailResponse.height} m"
        )
    }

    fun fromApiResponse(apiResponse: PokemonApiResponse): List<Pokemon> {
        return apiResponse.results.map { Pokemon(it.name, it.url) }
    }
}