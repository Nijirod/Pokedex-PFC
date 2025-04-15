package com.netexlearning.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.PokemonDetail
import com.netexlearning.pokemon.data.mapper.PokemonMapper.toDomain
import com.netexlearning.pokemon.data.mapper.PokemonMapper.toEntity
import com.netexlearning.pokemon.data.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {
    private val _pokemonDetail = MutableStateFlow<PokemonDetail?>(null)
    val pokemonDetail: StateFlow<PokemonDetail?> get() = _pokemonDetail

    fun fetchPokemonDetail(pokemonId: Int) {
        viewModelScope.launch {
            try {
                val detailFromDb = repository.getPokemonDetailFromDao(pokemonId)
                if (detailFromDb != null) {
                    _pokemonDetail.value = detailFromDb.toDomain()
                } else {
                    val detailFromApi = repository.getPokemonDetailFromApi(pokemonId)
                    repository.insertPokemonDetail(detailFromApi.toEntity())
                    _pokemonDetail.value = detailFromApi
                }
            } catch (e: Exception) {
                println("Error obteniendo detalles del Pokémon: ${e.message}")
            }
        }
    }
}