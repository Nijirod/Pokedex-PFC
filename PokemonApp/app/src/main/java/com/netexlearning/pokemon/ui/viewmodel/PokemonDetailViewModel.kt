package com.netexlearning.pokemon.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.netexlearning.pokemon.PokemonDetail
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
                repository.fetchAndStorePokemonDetailFromApi(pokemonId)
                val pokemonDetail = repository.getPokemonDetailFromDao(pokemonId)
                _pokemonDetail.value = pokemonDetail
            } catch (e: Exception) {
                println("Error obteniendo detalles del Pokémon: ${e.message}")
            }
        }
    }
}