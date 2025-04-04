package com.netexlearning.pokemon.data.mapper

import com.netexlearning.pokemon.Pokemon
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.StatDetail
import com.netexlearning.pokemon.api.Ability
import com.netexlearning.pokemon.api.Cries
import com.netexlearning.pokemon.api.Form
import com.netexlearning.pokemon.api.PokemonApiResponse
import com.netexlearning.pokemon.api.PokemonDetailResponse
import com.netexlearning.pokemon.api.Species
import com.netexlearning.pokemon.api.Sprites
import com.netexlearning.pokemon.api.TypeName

object PokemonMapper {
    fun fromDetailResponse(detailResponse: PokemonDetailResponse): PokemonDetail {
        return PokemonDetail(
            id = detailResponse.id,
            order = detailResponse.order,
            name = detailResponse.name,
            species = detailResponse.species?.let { Species(it.name,detailResponse.species.url) },
            types = detailResponse.types?.map { TypeName(it.type.name, it.type.url) },
            form = detailResponse.form?.let { Form(detailResponse.form.name, it.url) },
            isDefault = detailResponse.isDefault,
            cries = detailResponse.cries?.let { Cries(it.latest, detailResponse.cries.legacy) },
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
    fun fromApiResponse(apiResponse: PokemonApiResponse): Pokemon? {
        return apiResponse.name?.let {
            Pokemon(
                name = it,
                url = apiResponse.url
            )
        }
    }
}